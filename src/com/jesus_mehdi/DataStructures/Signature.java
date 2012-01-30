package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class Signature {
	
	private ArrayList<SimpleEntry<String, String>> _arguments;
	private String _returnType;
	private MethodEnvironment _methodEnvironment;
	
	public Signature(String returnType) {
		_arguments = new ArrayList<SimpleEntry<String,String>>();
		_returnType = returnType;
	}
	
	public Signature() {
		this("void");
	}
	
	public void setReturnType(String returnType) {
		_returnType = returnType;
	}
	
	public String getReturnType() {
		return _returnType;
	}
	
	public int getArgumentsCount() {
		return _arguments.size();
	}
	
	public int getLocalVariablesCount() {
		int argumentCount = getArgumentsCount();
		int allMemberCount = _methodEnvironment.getAllMemeberCount();
		
		return allMemberCount - argumentCount;
	}
	
	public ArrayList<SimpleEntry<String, String>> getAllArguments() {
		return _arguments;
	}
	
	private SimpleEntry<String, String> argumentAt(int argumentIndex) {
		return _arguments.get(argumentIndex);
	}
	
	public void addArgument(String argumentName, String argumentType) {
		SimpleEntry<String, String> argument = new SimpleEntry<String, String>(argumentName, argumentType);
		_arguments.add(argument);
	}
	
	public boolean containsArgument(String argumentName, String argumentType) {
		for (SimpleEntry<String, String> argument : _arguments)
			if (argument.getKey().equals(argumentName) && argument.getValue().equals(argumentType))
				return true;
		
		return false;
	}
	
	public boolean isSubSignatureOf(Signature signature) {
		if (getArgumentsCount() != signature.getArgumentsCount())
			return false;
		for (int i = 0; i < getArgumentsCount(); i++)
			if (argumentIsSubtype(argumentAt(i), signature.argumentAt(i)) == false)
					return false;
			
		return true;
	}
	
	public boolean isEqualTo(Signature signature) {
		return isSubMethod(signature) && signature.isSubMethod(this);
	}
	
	public boolean isSubMethod(Signature signature) {
		if (signature.isSubSignatureOf(this)) {
			ModuleEnvironment returnTypeCurrentModule = ApplicationMainSymbolTable.
				getModuleByName(getReturnType());
			ModuleEnvironment returnTypeOtherModule = ApplicationMainSymbolTable.
				getModuleByName(signature.getReturnType());
			if (returnTypeCurrentModule.isSubtypeOf(returnTypeOtherModule))
				return true;
		}
		
		return false;
	}
	
	private boolean argumentIsSubtype(SimpleEntry<String, String> arg, SimpleEntry<String, String> otherArg) {
		ModuleEnvironment module = ApplicationMainSymbolTable.getModuleByName(arg.getValue());
		ModuleEnvironment otherModule = ApplicationMainSymbolTable.getModuleByName(otherArg.getValue());
		
		return module.isSubtypeOf(otherModule);
	}

	public void setMethodEnvironment(MethodEnvironment methodEnvironment) {
		_methodEnvironment = methodEnvironment;
	}

	public MethodEnvironment getMethodEnvironment() {
		return _methodEnvironment;
	}

}
