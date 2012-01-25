package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.CommonTokenStream;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.MemberHandler;
import com.jesus_mehdi.Exceptions.DuplicateVariableDeclarationException;

public class MemberHandlerTest {

	@Test
	public void shouldSetVariableNameAppropriately() {

		FileUtility.writeSampleProgramContentToFile("int testVariable");
		MemberHandler memberHandler = new MemberHandler(new StubTokenizer(1));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		memberHandler.setName(commonTokenStream);
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
		memberHandler.endDeclaration();
		
		assertEquals(memberRow, moduleEnvironment.getRow("testVariable"));
	}
	
	@Test(expected = DuplicateVariableDeclarationException.class)
	public void shouldThrowsDuplicateDeclarationExceptionWhenTwoVariablesWithSameNameDeclared() {
		FileUtility.writeSampleProgramContentToFile("int testVariable\r\nint testVariable");
		handleVariableDeclaration(1);
		handleVariableDeclaration(3);
	}
	
	@Test
	public void shouldCalculateOffsetForVariablesCorrectly() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		SymbolTableRow firstRow = createRow("testInt", "int");
		memberHandler.setMemberRow(firstRow);
		memberHandler.endDeclaration();
		SymbolTableRow secondRow = createRow("testString", "string");
		memberHandler.setMemberRow(secondRow);
		memberHandler.endDeclaration();
		
		assertEquals(0, firstRow.Offset);
		assertEquals(1, secondRow.Offset);
	}
	
	@Test
	public void shouldCalculateSizeOfModule() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		memberHandler.setMemberRow(createRow("testInt", "int"));
		memberHandler.endDeclaration();
		memberHandler.setMemberRow(createRow("testString", "string"));
		memberHandler.endDeclaration();
		
		assertEquals(2, moduleEnvironment.getModuleSize());
	}
	
	@Test
	public void shouldCalculateArraySizeAndOffset() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		memberHandler.setMemberRow(createRow("testInt", "int"));
		memberHandler.endDeclaration();
		memberHandler.setMemberRow(createRow("testIntArray", "int", 4));
		memberHandler.endDeclaration();
		
		assertEquals(5, moduleEnvironment.getModuleSize());
	}
	
	private void checkVariableName(String expectedVariableName, int tokenizerIndex) {
		MemberHandler memberHandler = new MemberHandler(new StubTokenizer(tokenizerIndex));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		memberHandler.setName(commonTokenStream);
		SymbolTableRow memberRow = memberHandler.getMemberRow();
		
		assertEquals(expectedVariableName, memberRow.Name);
	}
	
	private void handleVariableDeclaration(int tokenizerIndex) {
		MemberHandler memberHandler = new MemberHandler(new StubTokenizer(tokenizerIndex));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
		memberHandler.setName(commonTokenStream);
		memberHandler.endDeclaration();
	}
	
	private SymbolTableRow createRow(String variableName, String typeName) {
		SymbolTableRow row = new SymbolTableRow();
		row.Name = variableName;
		row.Type = typeName;
		
		return row;
	}
	
	private SymbolTableRow createRow(String variableName, String typeName, int arraySize) {
		SymbolTableRow row = createRow(variableName, typeName);
		row.ArraySize = arraySize;
		
		return row;
	}
	
}
