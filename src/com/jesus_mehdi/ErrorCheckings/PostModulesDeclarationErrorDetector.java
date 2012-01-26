package com.jesus_mehdi.ErrorCheckings;

import java.util.ArrayList;
import java.util.Collection;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.SymbolTable;
import com.jesus_mehdi.Exceptions.MemberAlreadyDeclaredInParentException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class PostModulesDeclarationErrorDetector {

	public void checkErrors() {
	}
	
	public MethodSymbolTableRow getEquivalentVirtualMethodFromParent(ModuleEnvironment module, String methodName) {
//		ModuleEnvironment parentModule = (ModuleEnvironment)module.getParentScope();
//		while (parentModule != null) {
//			ArrayList<MethodSymbolTableRow>
//		}
		return null;
	}
	
	public void checkForDeclaringMemberInChildWhichIsAlreadyExistedInParent() {
		Collection<ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules().values();
		
		for (ModuleEnvironment module : allModules) {
			ArrayList<MemberSymbolTableRow> memberRows = module.getSymbolTable().getAllMemberRows();
			checkWhetherAnyMemberAlreadyExistedInParentModules(module, memberRows);
		}
	}

	private void checkWhetherAnyMemberAlreadyExistedInParentModules(
			ModuleEnvironment module, ArrayList<MemberSymbolTableRow> memberRows) {
		ModuleEnvironment parentModule = (ModuleEnvironment)module.getParentScope();
		while(parentModule != null) {
			throwExceptionWhenMemberAlreadyExistedInParent(memberRows, parentModule);
			parentModule =  (ModuleEnvironment)parentModule.getParentScope();
		}
	}

	private void throwExceptionWhenMemberAlreadyExistedInParent( ArrayList<MemberSymbolTableRow> memberRows,
			ModuleEnvironment parentModule) {
		SymbolTable parentSymbolTable = parentModule.getSymbolTable();
		for (MemberSymbolTableRow singleMemberRow : memberRows)
			if(parentSymbolTable.rowAlreadyExisted(singleMemberRow))
				throw new MemberAlreadyDeclaredInParentException();
	}

}
