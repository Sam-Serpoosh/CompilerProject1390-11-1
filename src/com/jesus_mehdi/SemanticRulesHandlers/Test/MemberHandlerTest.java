package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.Exceptions.DuplicateVariableDeclarationException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.MemberHandler;

public class MemberHandlerTest {

	@Test
	public void shouldSetVariableNameAppropriately() {

		FileUtility.writeSampleProgramContentToFile("int testVariable");
		MemberHandler memberHandler = new MemberHandler(new StubTokenizer(1));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		memberHandler.setMemberName(commonTokenStream);
		SymbolTableRow memberRow = memberHandler.getMemberRow();
		
		assertEquals("testVariable", memberRow.Name);
	}
	
	@Test
	public void shouldSetVariableNamesForMultipleVariablesCorrectly() {
		FileUtility.writeSampleProgramContentToFile("int testInt\r\nstring testString");
		checkVariableName("testInt", 1);
		checkVariableName("testString", 3);
	}
	
	@Test
	public void shouldSetVariableTypeAppropriately() {

		FileUtility.writeSampleProgramContentToFile("int testVariable");
		MemberHandler memberHandler = new MemberHandler(new StubTokenizer(0));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		memberHandler.setType(commonTokenStream);
		SymbolTableRow memberRow = memberHandler.getMemberRow();
		
		assertEquals("int", memberRow.Type);
	}
	
	@Test
	public void shouldAddMemeberRowToCurrentModuleScopeSymbolTable() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		MemberHandler memberHandler = new MemberHandler();
		SymbolTableRow memberRow = memberHandler.getMemberRow();
		
		Current.setCurrentScope(moduleEnvironment);
		memberRow.Name = "testVariable";
		memberRow.Type = "int";
		memberHandler.endMemberDeclaration();
		
		assertEquals(memberRow, moduleEnvironment.getRow("testVariable"));
	}
	
	@Test(expected = DuplicateVariableDeclarationException.class)
	public void shouldThrowsDuplicateDeclarationExceptionWhenTwoVariablesWithSameNameDeclared() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MemberSymbolTableRow row = createRow("testVariable", "int");
		MemberSymbolTableRow duplicateRow = createRow("testVariable", "int");
		MemberHandler memberHandler = new MemberHandler();
		memberHandler.setMemberRow(row);
		memberHandler.endMemberDeclaration();
		memberHandler.setMemberRow(duplicateRow);
		memberHandler.endMemberDeclaration();
	}
	
	@Test
	public void shouldCalculateOffsetForVariablesCorrectly() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		MemberSymbolTableRow firstRow = createRow("testInt", "int");
		memberHandler.setMemberRow(firstRow);
		memberHandler.endMemberDeclaration();
		MemberSymbolTableRow secondRow = createRow("testString", "string");
		memberHandler.setMemberRow(secondRow);
		memberHandler.endMemberDeclaration();
		
		assertEquals(0, firstRow.Offset);
		assertEquals(1, secondRow.Offset);
	}
	
	@Test
	public void shouldCalculateSizeOfModule() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		memberHandler.setMemberRow(createRow("testInt", "int"));
		memberHandler.endMemberDeclaration();
		memberHandler.setMemberRow(createRow("testString", "string"));
		memberHandler.endMemberDeclaration();
		
		assertEquals(2, moduleEnvironment.getModuleSize());
	}
	
	@Test
	public void shouldCalculateArraySizeAndOffset() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		memberHandler.setMemberRow(createRow("testInt", "int"));
		memberHandler.endMemberDeclaration();
		memberHandler.setMemberRow(createRow("testIntArray", "int", 4));
		memberHandler.endMemberDeclaration();
		
		assertEquals(5, moduleEnvironment.getModuleSize());
	}
	
	private void checkVariableName(String expectedVariableName, int tokenizerIndex) {
		MemberHandler memberHandler = new MemberHandler(new StubTokenizer(tokenizerIndex));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		memberHandler.setMemberName(commonTokenStream);
		SymbolTableRow memberRow = memberHandler.getMemberRow();
		
		assertEquals(expectedVariableName, memberRow.Name);
	}
	
	private MemberSymbolTableRow createRow(String variableName, String typeName) {
		MemberSymbolTableRow row = new MemberSymbolTableRow();
		row.Name = variableName;
		row.Type = typeName;
		
		return row;
	}
	
	private MemberSymbolTableRow createRow(String variableName, String typeName, int arraySize) {
		MemberSymbolTableRow row = createRow(variableName, typeName);
		row.ArraySize = arraySize;
		
		return row;
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
