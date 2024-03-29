package com.jesus_mehdi.SemanticRulesHandlers;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.Exceptions.MemberAndMethodExistWithSameNameException;
import com.jesus_mehdi.Exceptions.NoReturnForMethodException;
import com.jesus_mehdi.Exceptions.VariableMustNotBeVoidTypeException;

public class MethodHandler {

	private Tokenizer _tokenizer;
	private MethodSymbolTableRow _methodRow;
	private Signature _arguments;
	private Signature _environmentSignature;
	private String _argumentName;
	private String _argumentType;
	private MethodEnvironment _methodEnvironment;
	private MemberSymbolTableRow _memberRow;
	private ModuleEnvironment _parentModuleEnvironment;
	private String _environmentArgumentName;
	
	public MethodHandler(Tokenizer tokenizer) {
		_tokenizer = tokenizer;
		_methodRow = new MethodSymbolTableRow();
		_arguments = new Signature();
		setEnvironmentSignature(new Signature());
	}
	
	public MethodHandler() {
		this(new Tokenizer());
	}
	
	public MethodEnvironment getMethodEnvironment() {
		return _methodEnvironment;
	}
	
	public void setMethodEnvironment(MethodEnvironment methodEnvironment) {
		_methodEnvironment = methodEnvironment;
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
	
	public void setMemberRow(MemberSymbolTableRow memberRow) {
		_memberRow = memberRow;
	}
	
	public MemberSymbolTableRow getMemberRow() {
		 return _memberRow;
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
		if (_argumentType.equals("void"))
			throw new VariableMustNotBeVoidTypeException();
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
		_parentModuleEnvironment = (ModuleEnvironment)Current.getScope();
		Current.stepIntoScope(_methodEnvironment);
	}

	public void endMethodScope() {
		_parentModuleEnvironment.addMethodEnvironment(_methodEnvironment);
		if (_methodEnvironment.hasReturnSeen() == false)
			throw new NoReturnForMethodException();
		Current.stepOutToPrevScope();
		
	}

	public void setMethodEnvironmentName(TokenStream input) {
		String methodEnvironmentName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		_methodEnvironment.setName(methodEnvironmentName);
	}

	public void addArgumentNameToMethodEnvironment(TokenStream input) {
		String argumentName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		_environmentArgumentName = argumentName;
		_memberRow = new MemberSymbolTableRow();
		_memberRow.Name = argumentName;
	}

	public void setArgumentTypeInMethodEnvironment(TokenStream input) {
		String typeName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		getEnvironmentSignature().addArgument(_environmentArgumentName, typeName);
		_memberRow.Type = typeName;
		_methodEnvironment.addRow(_memberRow);
	}

	public void setReturnTypeInMethodEnvironment(TokenStream input) {
		String returnTypeName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		getEnvironmentSignature().setReturnType(returnTypeName);
		_methodEnvironment.setReturnType(returnTypeName);
	}

	public void setEnvironmentForAppropriateSignature() {
		ModuleEnvironment currentModule = (ModuleEnvironment)Current.getParentScope();
		MethodSymbolTableRow methodRow = currentModule.getSymbolTable().
			getMethodRowByName(_methodEnvironment.getName());
		
		for (Signature signature : methodRow.getAllSignatures())
			if (getEnvironmentSignature().isEqualTo(signature)) {
				signature.setMethodEnvironment(_methodEnvironment);
				return;
			}
	}

	public void setEnvironmentSignature(Signature environmentSignature) {
		_environmentSignature = environmentSignature;
	}

	public Signature getEnvironmentSignature() {
		return _environmentSignature;
	}
	
}
