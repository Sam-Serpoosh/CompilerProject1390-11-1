package com.jesus_mehdi.SemanticRulesHandlers;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.OffsetFactory;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.Exceptions.MemberAndMethodExistWithSameNameException;

public class MethodHandler {

	private Tokenizer _tokenizer;
	private MethodSymbolTableRow _methodRow;
	private OffsetFactory _offsetFactory;
	private Signature _arguments;
	private String _argumentName;
	private String _argumentType;
	private MethodEnvironment _methodEnvironment;
	
	public MethodHandler(Tokenizer tokenizer) {
		_tokenizer = tokenizer;
		_offsetFactory = new OffsetFactory();
		_methodRow = new MethodSymbolTableRow();
		_arguments = new Signature();
	}
	
	public MethodHandler() {
		this(new Tokenizer());
	}
	
	public void setArguments(Signature arguments) {
		_arguments = arguments;
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
		String methodName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		_methodRow.Name = methodName;
	}

	public void addArgumentName(TokenStream input) {
		_argumentName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
	}

	public void setArgumentType(TokenStream input) {
		_argumentType = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		_arguments.addArgument(_argumentName, _argumentType);
	}

	public void setReturnType(TokenStream input) {
		String returnType = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		_arguments.setReturnType(returnType);
	}

	public void endMethodDeclaration() {
		ModuleEnvironment moduleEnvironment = (ModuleEnvironment)Current.getScope();
		_methodRow.addSignature(_arguments);
		if (_methodRow.Name.toLowerCase().equals("main"))
			moduleEnvironment.setContainsMainMethod();
		SymbolTableRow memberRow = moduleEnvironment.getRow(_methodRow.Name);
		if (memberRow instanceof MemberSymbolTableRow)
			throw new MemberAndMethodExistWithSameNameException();
		
		moduleEnvironment.addRow(_methodRow);
	}

	public void setVirtual() {
		_methodRow.setVirtual();
	}

	public void beginMethodScope() {
		_methodEnvironment = new MethodEnvironment();
		Current.stepIntoScope(_methodEnvironment);
	}

	public void endMethodScope() {
		Current.stepOutToPrevScope();
	}
	
}
