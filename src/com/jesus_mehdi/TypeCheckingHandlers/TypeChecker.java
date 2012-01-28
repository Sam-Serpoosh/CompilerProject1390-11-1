package com.jesus_mehdi.TypeCheckingHandlers;

import java.util.Stack;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.Environment;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.TypeMismatchException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.Tokenizer;

public class TypeChecker {

	private Stack _typeCheckingStack;
	private Tokenizer _tokenizer;
	
	public TypeChecker() {
		_typeCheckingStack = new Stack<ModuleEnvironment>();
		_tokenizer = new Tokenizer();
	}
	
	public void assignmentOperator() {
		ModuleEnvironment rightType = (ModuleEnvironment)_typeCheckingStack.pop();
		ModuleEnvironment leftType = (ModuleEnvironment)_typeCheckingStack.pop();
		
		if (rightType.isSubtypeOf(leftType) == false)
			throw new TypeMismatchException();
	}

	public void setConstStringInput() {
		_typeCheckingStack.push(ApplicationMainSymbolTable.getModuleByName("string"));
	}

	public void setConstBoolInput() {
		_typeCheckingStack.push(ApplicationMainSymbolTable.getModuleByName("bool"));
	}

	public void setConstIntInput() {
		_typeCheckingStack.push(ApplicationMainSymbolTable.getModuleByName("int"));
	}

	public void setInputId(TokenStream input) {
		String variableName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		fetchVariableTypeAndPutItIntoTypeCheckingStack(variableName);
	}
	
	public void fetchVariableTypeAndPutItIntoTypeCheckingStack(String variableName) {
		Environment currentModule = Current.getScope();
		_typeCheckingStack.push(currentModule.getVariableType(variableName));
	}

}
