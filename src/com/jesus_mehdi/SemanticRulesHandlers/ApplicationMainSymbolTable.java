package com.jesus_mehdi.SemanticRulesHandlers;

import java.util.HashMap;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;

public class ApplicationMainSymbolTable {

	private static HashMap<String, ModuleEnvironment> _allModules = new HashMap<String, ModuleEnvironment>();

	public static void addModule(ModuleEnvironment moduleEnvironment) {
		_allModules.put(moduleEnvironment.getName(), moduleEnvironment);
	}

}
