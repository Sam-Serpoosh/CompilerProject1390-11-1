package com.jesus_mehdi.ErrorCheckings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.LoopInheritanceException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class ModuleErrorDetector {

	private HashMap<ModuleEnvironment, Boolean> _modulesMetState;
	
	public ModuleErrorDetector() {
		fillAllModulesCollection();
	}
	
	private void fillAllModulesCollection() {
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
