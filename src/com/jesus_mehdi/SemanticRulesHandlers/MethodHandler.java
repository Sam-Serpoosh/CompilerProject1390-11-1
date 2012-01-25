package com.jesus_mehdi.SemanticRulesHandlers;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.OffsetFactory;

public class MethodHandler {

	private Tokenizer _tokenizer;
	private MethodSymbolTableRow _methodRow;
	private final int LAST_TOKEN = -1;
	private OffsetFactory _offsetFactory;
	private ArrayList<Entry<String, String>> _arguments;
	private String _argumentName;
	private String _argumentType;
	
	public MethodHandler(Tokenizer tokenizer) {
		_tokenizer = tokenizer;
		_offsetFactory = new OffsetFactory();
		_methodRow = new MethodSymbolTableRow();
		_arguments = new ArrayList<Entry<String,String>>();
	}
	
	public MethodHandler() {
		this(new Tokenizer());
	}
	
	public MethodSymbolTableRow getMethodRow() {
		return _methodRow;
	}
	
	public void setMethodRow(MethodSymbolTableRow methodRow) {
		_methodRow = methodRow;
	}
	
	public String getArgumentName() {
		return _argumentName;
	}
	
	public String getArgumentType() {
		return _argumentType;
	}

	public void setMethodName(TokenStream input) {
		String methodName = _tokenizer.getSpecificToken((CommonTokenStream)input, LAST_TOKEN);
		_methodRow.Name = methodName;
	}

	public void addArgumentName(TokenStream input) {
		_argumentName = _tokenizer.getSpecificToken((CommonTokenStream)input, LAST_TOKEN);
	}

	public void setArgumentType(TokenStream input) {
		_argumentType = _tokenizer.getSpecificToken((CommonTokenStream)input, LAST_TOKEN);
		SimpleEntry<String, String> argument = new SimpleEntry<String, String>(_argumentName, _argumentType);
		_arguments.add(argument);
	}

	public void setReturnType(TokenStream input) {
		String returnType = _tokenizer.getSpecificToken((CommonTokenStream)input, LAST_TOKEN);
		_methodRow.Type = returnType;
	}

	public void endMethodDeclaration() {
		ModuleEnvironment moduleEnvironment = (ModuleEnvironment)Current.getScope();
		if (_methodRow.Name.toLowerCase().equals("main"))
			moduleEnvironment.setContainsMainMethod();
		
		moduleEnvironment.addRow(_methodRow);
	}
	
}
