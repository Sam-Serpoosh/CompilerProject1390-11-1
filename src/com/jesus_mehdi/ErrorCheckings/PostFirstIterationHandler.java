package com.jesus_mehdi.ErrorCheckings;

import java.util.Collection;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;


public class PostFirstIterationHandler {

	private MethodErrorDetector _methodErrorDetector;
	private MemberErrorDetector _memberErrorDetector;
	private ModuleErrorDetector _moduleErrorDetector;
	
	public PostFirstIterationHandler() {
		setParentScopesForAllModules();
		_methodErrorDetector = new MethodErrorDetector();
		_memberErrorDetector = new MemberErrorDetector();
		_moduleErrorDetector = new ModuleErrorDetector();
	}
	
	public void checkErrors() {
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

}
