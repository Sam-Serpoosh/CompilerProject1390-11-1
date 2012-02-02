package com.jesus_mehdi.TypeCheckingHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.TypeCheckingHandlers.TypeChecker;
import com.jesus_mehdi.TypeCheckingHandlers.TypeCheckerFactory;

public class ChangeScopeDuringTypeCheckingTest extends TypeCheckerTest {

	@Test
	public void whenCurrentScopeChangedTypeCheckerShouldCheckFromCurrentScopeToUp() {
		ModuleEnvironment currentModule = new ModuleEnvironment();
		currentModule.setName("CurrentModule");
		Current.setCurrentScope(currentModule);
		ApplicationMainSymbolTable.init();
		ApplicationMainSymbolTable.addModule(currentModule);
		TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker();
		MethodEnvironment currentMethod = new MethodEnvironment();
		currentMethod.setName("CurrentMethod");
		currentMethod.setParentScope(currentModule);
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = "testVariable";
		memberRow.Type = "int";
		currentMethod.addRow(memberRow);
		Current.setCurrentScope(currentMethod);
		typeChecker.resetCurrentContainerEnvironment();
		
		typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("testVariable");
		
		assertEquals(1, typeChecker.getTypeCheckingStackSize());
		assertEquals("int", typeChecker.getTypeAt(0).getName());
	}
	
}
