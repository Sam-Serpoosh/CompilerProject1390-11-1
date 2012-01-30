package com.jesus_mehdi.ErrorCheckings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.AbstractMap.SimpleEntry;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.OffsetFactory;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;


public class PostFirstIterationHandler {

	private MethodErrorDetector _methodErrorDetector;
	private MemberErrorDetector _memberErrorDetector;
	private ModuleErrorDetector _moduleErrorDetector;
	
	public PostFirstIterationHandler() {
		setParentScopesForAllModules();
		checkForUndefinedTypeExceptionInAllModulesMembers();
		checkForUndefinedTypeExceptionInAllModulesMethods();
		_methodErrorDetector = new MethodErrorDetector();
		_memberErrorDetector = new MemberErrorDetector();
		_moduleErrorDetector = new ModuleErrorDetector();
	}
	
	public void checkErrors() {
		_moduleErrorDetector.checkForInheritanceFromBaseTypes();
		_moduleErrorDetector.checkForLoopInInheritance();
		_methodErrorDetector.checkOverloadingProblemsInAllModules();
		_methodErrorDetector.checkOverridingProblemsInAllModules();
		_memberErrorDetector.checkForDeclaringMemberInChildWhichIsAlreadyExistedInParent();
	}
	
	public void setParentScopesForAllModules() {
		Collection<ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules().values();
		for (ModuleEnvironment module : allModules) {
			ModuleEnvironment parentModule = ApplicationMainSymbolTable.getModuleByName(module.getParentName());
			module.setParentScope(parentModule);
		}
	}
	
	public void addAllModulesWithSizeToOffsetFactory() {
		OffsetFactory offsetFactory = new OffsetFactory();
		Collection<ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules().values();
		for (ModuleEnvironment module : allModules)
			offsetFactory.registerModuleType(module.getName(), 1);
	}
	
	
	public void checkForUndefinedTypeExceptionInAllModulesMembers() {
		Collection<ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules().values();
		for (ModuleEnvironment module : allModules) {
			ArrayList<MemberSymbolTableRow> moduleMemberRows = module.getSymbolTable().getAllMemberRows();
			for (MemberSymbolTableRow memberRow : moduleMemberRows) {
				String memberTypeName = memberRow.Type;
				ApplicationMainSymbolTable.getModuleByName(memberTypeName);
			}
		}
	}
	
	public void checkForUndefinedTypeExceptionInAllModulesMethods() {
		Collection<ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules().values();
		for (ModuleEnvironment module : allModules) {
			ArrayList<MethodSymbolTableRow> moduleMethodRows = module.getSymbolTable().getAllMethodRows();
			for (MethodSymbolTableRow methodRow : moduleMethodRows) {
				ArrayList<Signature> allMethodSignatures = methodRow.getAllSignatures();
				for (Signature signature : allMethodSignatures)
					checkForUndefinedTypeInMethodSignature(signature);
			}
		}
	}

	private void checkForUndefinedTypeInMethodSignature(Signature signature) {
		for (SimpleEntry<String, String> argument : signature.getAllArguments())
			ApplicationMainSymbolTable.getModuleByName(argument.getValue());
		
		ApplicationMainSymbolTable.getModuleByName(signature.getReturnType());
	}
}
