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
		SymbolTableRow firstRow = new SymbolTableRow();
		firstRow.Name = "testInt";
		firstRow.Type = "int";
		memberHandler.setMemberRow(firstRow);
		memberHandler.endDeclaration();
		SymbolTableRow secondRow = new SymbolTableRow();
		secondRow.Name = "testString";
		secondRow.Type = "string";
		memberHandler.setMemberRow(secondRow);
		memberHandler.endDeclaration();
		
		assertEquals(0, firstRow.Offset);
		assertEquals(4, secondRow.Offset);
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
	
}
