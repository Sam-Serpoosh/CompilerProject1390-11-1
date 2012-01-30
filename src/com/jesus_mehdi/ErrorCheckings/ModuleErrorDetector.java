package com.jesus_mehdi.ErrorCheckings;

import java.util.Collection;
import java.util.HashMap;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.InheritanceFromBaseTypeException;
import com.jesus_mehdi.Exceptions.LoopInheritanceException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class ModuleErrorDetector {

	private HashMap<ModuleEnvironment, Boolean> _modulesMetState;
	
	public ModuleErrorDetector() {
		resetAllModulesMetStateForLoopInheritance();
	}
	
	public void checkForInheritanceFromBaseTypes() {
		for (ModuleEnvironment module : ApplicationMainSymbolTable.getAllModules().values()) {
			if (module.getParentScope() != null) {
				ModuleEnvironment parentModule = (ModuleEnvironment)module.getParentScope();
				if (parentModule.isBaseType())
					throw new InheritanceFromBaseTypeException();
			}
		}
	}
	
	private void resetAllModulesMetStateForLoopInheritance() {
		_modulesMetState = new HashMap<ModuleEnvironment, Boolean>();
		Collection<ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules().values();
		for (ModuleEnvironment module : allModules)
			_modulesMetState.put(module, false);
	}

	public void checkForLoopInInheritance() {
		for (ModuleEnvironment module : _modulesMetState.keySet()) {
			checkModuleForInheritanceLoop(module);
			resetModulesMetState();
		}
	}

	private void checkModuleForInheritanceLoop(ModuleEnvironment module) {
		ModuleEnvironment visitedModule = module;
		while (visitedModule.getParentScope() != null) {
			if (_modulesMetState.get(visitedModule).equals(true))
				throw new LoopInheritanceException();
			
			_modulesMetState.put(visitedModule, true);
			visitedModule = (ModuleEnvironment)visitedModule.getParentScope();
		}
	}
	
	private void resetModulesMetState() {
		for (ModuleEnvironment module : _modulesMetState.keySet())
			_modulesMetState.put(module, false);
	}
	
}
