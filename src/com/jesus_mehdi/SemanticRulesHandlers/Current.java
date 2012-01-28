package com.jesus_mehdi.SemanticRulesHandlers;

import com.jesus_mehdi.DataStructures.Environment;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;

public class Current {

	private static Environment _scope;
	
	public static void setCurrentScope(Environment environment) {
		_scope = environment;
	}
	
	public static void setCurrentScopeToPrev() {
		_scope = _scope.getParentScope();
	}
	
	public static Environment getScope() {
		return _scope;
	}

	public static void setCurrentScopeByModuleName(String currentModuleName) {
		ModuleEnvironment currentModule = ApplicationMainSymbolTable.getModuleByName(currentModuleName);
		setCurrentScope(currentModule);
	}
	
}
