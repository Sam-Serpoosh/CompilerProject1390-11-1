package com.jesus_mehdi.ErrorCheckings.Test;

import org.junit.After;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.ErrorCheckings.MemberErrorDetector;
import com.jesus_mehdi.Exceptions.MemberAlreadyDeclaredInParentException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class MemberErrorDetectorTest {

	@Test(expected = MemberAlreadyDeclaredInParentException.class)
	public void shouldThrowExceptionWhenMemberAlreadyExistedInParents() {
		ModuleEnvironment parentModule = new ModuleEnvironment();
		declareRowAndAddItToModule("testVariable", "string", parentModule);
		ModuleEnvironment childModule = new ModuleEnvironment();
		declareRowAndAddItToModule("testVariable", "string", childModule);
		childModule.setParentScope(parentModule);
		ApplicationMainSymbolTable.addModule(parentModule);
		ApplicationMainSymbolTable.addModule(childModule);
		
		MemberErrorDetector errorDetector = new MemberErrorDetector();
		errorDetector.checkForDeclaringMemberInChildWhichIsAlreadyExistedInParent();
	}
	
	private void declareRowAndAddItToModule(String memberName, String memberType, ModuleEnvironment module) {
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = "testVariable";
		memberRow.Type = "string";
		module.addRow(memberRow);
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
