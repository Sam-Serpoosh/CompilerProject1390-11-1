package com.jesus_mehdi.SemanticRulesHandlers;

import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;

public class ModuleHandler {

	private Tokenizer _tokenizer;
	private ModuleEnvironment _moduleEnvironment;
	private final int LAST_TOKEN = -1;
	
	public ModuleHandler(Tokenizer tokenizer) {
		_tokenizer = tokenizer;
	}
	
	public ModuleHandler() {
		this(new Tokenizer());
	}
	
	public void startModule() {
		_moduleEnvironment = new ModuleEnvironment();
	}
	
	public ModuleEnvironment getModuleEnvironment() {
		return _moduleEnvironment;
	}

	public void setModuleName(TokenStream moduleNameToken) {
		String moduleName = _tokenizer.getSpecificToken((CommonTokenStream)moduleNameToken, LAST_TOKEN);
		_moduleEnvironment.setName(moduleName);
		ApplicationMainSymbolTable.addModule(_moduleEnvironment);
	}

	public void setParentModuleName(TokenStream parentModuleNameToken) {
		String parentModuleName = _tokenizer.getSpecificToken((CommonTokenStream)parentModuleNameToken, LAST_TOKEN);
		_moduleEnvironment.setParentName(parentModuleName);
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
