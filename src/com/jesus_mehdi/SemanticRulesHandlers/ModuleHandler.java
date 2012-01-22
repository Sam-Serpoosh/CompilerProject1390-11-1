package com.jesus_mehdi.SemanticRulesHandlers;

import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.*;

public class ModuleHandler {

	private static ModuleEnvironment _moduleEnvironment;

	public static void startModule() {
		_moduleEnvironment = new ModuleEnvironment();
		ApplicationMainSymbolTable.addModule(_moduleEnvironment);
	}

	public static void setName(TokenStream moduleNameToken) {
		String moduleName = tokenAt(moduleNameToken, -1);
		_moduleEnvironment.setName(moduleName);
	}

	public static void setParentModule(TokenStream parentModuleNameToken) {
		String parentModuleName = tokenAt(parentModuleNameToken, -1);
		_moduleEnvironment.setParentName(parentModuleName);
	}

	public static String tokenAt(TokenStream inputToken, int tokenIndex) {
		return inputToken.LT(tokenIndex).getText();
	}
	
	public void startScope() {
		Current.setCurrentScope(_moduleEnvironment);
	}
	
	public void endModuleScope() {
		Current.setCurrentScopeToPrev();
	}

}
