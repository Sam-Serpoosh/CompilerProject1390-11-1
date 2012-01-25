package com.jesus_mehdi.SemanticRulesHandlers;

import java.util.HashMap;
import java.util.Map.Entry;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.MultipleMainMethodsException;
import com.jesus_mehdi.Exceptions.NoMainMethodException;

public class ApplicationMainSymbolTable {

	private static HashMap<String, ModuleEnvironment> _allModules = new HashMap<String, ModuleEnvironment>();
	private static ModuleEnvironment _applicationEntryModule;

	public static void addModule(ModuleEnvironment moduleEnvironment) {
		_allModules.put(moduleEnvironment.getName(), moduleEnvironment);
	}
	
	public static HashMap<String, ModuleEnvironment> getAllModules() {
		return _allModules;
	}
	
	public static ModuleEnvironment getApplicationEntryModule() {
		return _applicationEntryModule;
	}
	
	public static boolean moduleAlreadyDefined(String moduleName) {
		return _allModules.containsKey(moduleName);
	}
	
	private static int numberOfMainMethods() {
		int mainCount = 0;
		for (ModuleEnvironment module : _allModules.values())
			if (module.alreadyContainsMainMethod())
				mainCount++;
		
		return mainCount;
	}
	
	public static void setApplicationEntryPoint() {
		int mainMethodsCount = numberOfMainMethods();
		if (mainMethodsCount == 0)
			throw new NoMainMethodException();
		else if (mainMethodsCount >= 2)
			throw new MultipleMainMethodsException();
		
		for (ModuleEnvironment module : _allModules.values())
			if (module.alreadyContainsMainMethod())
				_applicationEntryModule = module;
	}
	
}
