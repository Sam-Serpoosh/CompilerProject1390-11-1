package com.jesus_mehdi.SemanticRulesHandlers;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.OffsetFactory;

public class ModuleHandler {

	private Tokenizer _tokenizer;
	private ModuleEnvironment _moduleEnvironment;
	private final int LAST_TOKEN = -1;
	private OffsetFactory _offsetFactory;
	
	public ModuleHandler(Tokenizer tokenizer) {
		_tokenizer = tokenizer;
		_offsetFactory = new OffsetFactory();
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
	
	public void beginModuleScope() {
		Current.setCurrentScope(_moduleEnvironment);
	}
	
	public void endModuleScope() {
		int moduleSize = _moduleEnvironment.getCurrentOffset();
		_offsetFactory.registerModuleType(_moduleEnvironment.getName(), moduleSize);
		Current.setCurrentScopeToPrev();
	}
	
	private String tokenAt(TokenStream inputToken, int tokenIndex) {
		return inputToken.LT(tokenIndex).getText();
	}

}
