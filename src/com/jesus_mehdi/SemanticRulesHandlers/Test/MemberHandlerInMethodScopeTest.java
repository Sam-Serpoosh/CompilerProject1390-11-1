package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.SymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.MemberHandler;

public class MemberHandlerInMethodScopeTest {

	@Test
	public void shouldFillMethodEnvironmentSymbolTable() {
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		Current.setCurrentScope(methodEnvironment);
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = "testInt";
		memberRow.Type = "int";
		MemberHandler memberHandler = new MemberHandler();
		memberHandler.setMemberRow(memberRow);
		memberHandler.endMemberDeclaration();
		memberRow = new MemberSymbolTableRow();
		memberRow.Name = "testString";
		memberRow.Type = "string";
		memberHandler.setMemberRow(memberRow);
		memberHandler.endMemberDeclaration();
		
		SymbolTable methodSymbolTable = Current.getScope().getSymbolTable();
		assertEquals(2, methodSymbolTable.getSize());
		
		MemberSymbolTableRow methodMemberRow = (MemberSymbolTableRow)methodSymbolTable.getRow("testString");
		assertEquals("string", methodMemberRow.Type);
		
		methodMemberRow = (MemberSymbolTableRow)methodSymbolTable.getRow("testInt");
		assertEquals("int", methodMemberRow.Type);
	}

	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
