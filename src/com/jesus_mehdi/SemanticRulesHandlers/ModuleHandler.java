package com.jesus_mehdi.SemanticRulesHandlers;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.OffsetFactory;
import com.jesus_mehdi.Exceptions.DuplicateModuleDeclarationException;

public class ModuleHandler {

	private Tokenizer _tokenizer;
	private ModuleEnvironment _moduleEnvironment;
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
		String moduleName = _tokenizer.getSpecificToken((CommonTokenStream)moduleNameToken, _tokenizer.LAST_TOKEN);
		_moduleEnvironment.setName(moduleName);
		if (ApplicationMainSymbolTable.moduleAlreadyDefined(moduleName))
			throw new DuplicateModuleDeclarationException();
		
		ApplicationMainSymbolTable.addModule(_moduleEnvironment);
	}

	public void setParentModuleName(TokenStream parentModuleNameToken) {
		String parentModuleName = _tokenizer.getSpecificToken((CommonTokenStream)parentModuleNameToken, _tokenizer.LAST_TOKEN);
		_moduleEnvironment.setParentName(parentModuleName);
	}
	
	public void beginModuleScope() {
		Current.setCurrentScope(_moduleEnvironment);
	}
	
	public void endModuleScope() {
		int moduleSize = _moduleEnvironment.getModuleSize();
		_offsetFactory.registerModuleType(_moduleEnvironment.getName(), moduleSize);
		Current.stepOutToPrevScope();
	}
	
	public void setCurrentScopeByModuleName(TokenStream input) {
		String currentModuleName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		Current.setCurrentScopeByModuleName(currentModuleName);
	}
	
}
