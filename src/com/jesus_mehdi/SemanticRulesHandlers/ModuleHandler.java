package com.jesus_mehdi.SemanticRulesHandlers;

import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;

public class ModuleHandler {

	private ModuleEnvironment _moduleEnvironment;
	private final int LAST_TOKEN = -1;
	
	public void startModule() {
		_moduleEnvironment = new ModuleEnvironment();
	}
	
	public ModuleEnvironment getModuleEnvironment() {
		return _moduleEnvironment;
	}

	public void setModuleName(TokenStream moduleNameToken) {
		String moduleName = getSpecificToken((CommonTokenStream)moduleNameToken, LAST_TOKEN);
		_moduleEnvironment.setName(moduleName);
		ApplicationMainSymbolTable.addModule(_moduleEnvironment);
	}

	public void setParentModuleName(TokenStream parentModuleNameToken) {
		String parentModuleName = getSpecificToken((CommonTokenStream)parentModuleNameToken, LAST_TOKEN);
		_moduleEnvironment.setParentName(parentModuleName);
	}

	public String getSpecificToken(CommonTokenStream inputToken, int tokenIndex) {
		List<Token> allTokens = ((CommonTokenStream)inputToken).getTokens();
		int index = ((CommonTokenStream)inputToken).index();
		String tokenText = allTokens.get(index + tokenIndex).getText();
		
		return tokenText;
	}
	
	public void beginScope() {
		Current.setCurrentScope(_moduleEnvironment);
	}
	
	public void endModuleScope() {
		Current.setCurrentScopeToPrev();
	}
	
	private String tokenAt(TokenStream inputToken, int tokenIndex) {
		return inputToken.LT(tokenIndex).getText();
	}

}
