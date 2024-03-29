package com.jesus_mehdi.SemanticRulesHandlers;

import java.util.HashMap;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.BaseModuleNotExistedException;
import com.jesus_mehdi.Exceptions.MultipleMainMethodsException;
import com.jesus_mehdi.Exceptions.NoMainMethodException;
import com.jesus_mehdi.Exceptions.UndefinedModuleException;

public class ApplicationMainSymbolTable {

	private static HashMap<String, ModuleEnvironment> _allModules = new HashMap<String, ModuleEnvironment>();
	private static ModuleEnvironment _applicationEntryModule;
	
	public static void init() {
		createBaseModuleAndAddToAllModules("int");
		createBaseModuleAndAddToAllModules("string");
		createBaseModuleAndAddToAllModules("bool");
		createBaseModuleAndAddToAllModules("void");
		createBaseModuleAndAddToAllModules("Object");
	}

	private static void createBaseModuleAndAddToAllModules(String baseModuleName) {
		ModuleEnvironment module = new ModuleEnvironment();
		module.setName(baseModuleName);
		_allModules.put(baseModuleName, module);
	}

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
	
	public static ModuleEnvironment getModuleByName(String moduleName) {
		if (moduleName == "" || moduleName == null)
			return null;
		if (_allModules.containsKey(moduleName) == false)
			throw new UndefinedModuleException();
		
		return _allModules.get(moduleName); 
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

	public static void checkThatAllParentModulesExist() {
		for (ModuleEnvironment module : _allModules.values()) {
			String parentName = module.getParentName();
			if (_allModules.containsKey(parentName) == false)
				throw new BaseModuleNotExistedException();
		}
	}
	
	public static void clearMainSymbolTable() {
		getAllModules().clear();
		Current.setCurrentScope(null);
	}
	
}
