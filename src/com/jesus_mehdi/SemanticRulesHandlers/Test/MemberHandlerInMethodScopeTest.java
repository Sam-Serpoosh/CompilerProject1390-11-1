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
		MemberHandler memberHandler = new MemberHandler();
		declareMemberRowAndAddItToCurrentScope(memberHandler, "testInt", "int");
		declareMemberRowAndAddItToCurrentScope(memberHandler, "testString", "string");
		
		SymbolTable methodSymbolTable = Current.getScope().getSymbolTable();
		assertEquals(2, methodSymbolTable.getSize());
		
		MemberSymbolTableRow methodMemberRow = (MemberSymbolTableRow)methodSymbolTable.getRow("testString");
		assertEquals("string", methodMemberRow.Type);
		
		methodMemberRow = (MemberSymbolTableRow)methodSymbolTable.getRow("testInt");
		assertEquals("int", methodMemberRow.Type);
	}
	
	private void declareMemberRowAndAddItToCurrentScope(MemberHandler memberHandler, String variableName, String type) {
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = variableName;
		memberRow.Type = type;
		memberHandler.setMemberRow(memberRow);
		memberHandler.endMemberDeclaration();		
	}

	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
