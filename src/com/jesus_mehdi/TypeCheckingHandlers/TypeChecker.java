package com.jesus_mehdi.TypeCheckingHandlers;

import java.util.Stack;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.Environment;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.TypeMismatchException;
import com.jesus_mehdi.Exceptions.TypeOfUnaryMinusOperatorMustBeIntException;
import com.jesus_mehdi.Exceptions.TypesOfBinaryMathematicalOperatorsMustBeIntException;
import com.jesus_mehdi.Exceptions.TypesOfBooleanOperatorsMustBeBooleanException;
import com.jesus_mehdi.Exceptions.TypesOfEqualityRelationOperatorsMustBeSameBaseTypesException;
import com.jesus_mehdi.Exceptions.TypesOfRelationalOperatorsMustBeIntException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.Tokenizer;

public class TypeChecker {

	private Stack<ModuleEnvironment> _typeCheckingStack;
	private Tokenizer _tokenizer;
	
	public TypeChecker() {
		_typeCheckingStack = new Stack<ModuleEnvironment>();
		_tokenizer = new Tokenizer();
	}
	
	public void assignmentOperator() {
		ModuleEnvironment rightType = _typeCheckingStack.pop();
		ModuleEnvironment leftType = _typeCheckingStack.pop();
		
		if (rightType.isSubtypeOf(leftType) == false)
			throw new TypeMismatchException();
	}
	
	public void pushType(ModuleEnvironment type) {
		_typeCheckingStack.push(type);
	}
	
	public ModuleEnvironment getTypeAt(int typeIndex) {
		return _typeCheckingStack.get(typeIndex);
	}
	
	public int getTypeCheckingStackSize() {
		return _typeCheckingStack.size();
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

	public void orOperator() {
		binaryBooleanOperator();
	}

	public void andOperator() {
		binaryBooleanOperator();
	}

	private void binaryBooleanOperator() {
		ModuleEnvironment rightOperandType = _typeCheckingStack.pop();
		ModuleEnvironment leftOperandType = _typeCheckingStack.pop();
		ModuleEnvironment boolType = ApplicationMainSymbolTable.getModuleByName("bool");
		
		if (rightOperandType.isSubtypeOf(boolType) && leftOperandType.isSubtypeOf(boolType))
			_typeCheckingStack.push(boolType);
		else
			throw new TypesOfBooleanOperatorsMustBeBooleanException();
	}

	public void notOperator() {
		ModuleEnvironment operandType = _typeCheckingStack.pop();
		ModuleEnvironment boolType = ApplicationMainSymbolTable.getModuleByName("bool");
		
		if (operandType.isSubtypeOf(boolType))
			_typeCheckingStack.push(boolType);
		else
			throw new TypesOfBooleanOperatorsMustBeBooleanException();
	}

	public void clearTypeCheckingStack() {
		_typeCheckingStack.clear();
	}

	public void equalityRelationOperators() {
		ModuleEnvironment rightOperandType = _typeCheckingStack.pop();
		ModuleEnvironment leftOperandType = _typeCheckingStack.pop();
		ModuleEnvironment boolType = ApplicationMainSymbolTable.getModuleByName("bool");
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		ModuleEnvironment stringType = ApplicationMainSymbolTable.getModuleByName("string");
		
		if (haveSameType(rightOperandType, leftOperandType, boolType) || 
			haveSameType(rightOperandType, leftOperandType, intType) ||
			haveSameType(rightOperandType, leftOperandType, stringType))
			_typeCheckingStack.push(boolType);
		else
			throw new TypesOfEqualityRelationOperatorsMustBeSameBaseTypesException();
	}
	
	private boolean haveSameType(ModuleEnvironment rightOperandType, ModuleEnvironment leftOperandType, 
			ModuleEnvironment type) {
		return rightOperandType.isSubtypeOf(type) && leftOperandType.isSubtypeOf(type);
	}

	public void relationalOperator() {
		ModuleEnvironment rightOperandType = _typeCheckingStack.pop();
		ModuleEnvironment leftOperandType = _typeCheckingStack.pop();
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		ModuleEnvironment boolType = ApplicationMainSymbolTable.getModuleByName("bool");
		
		if (haveSameType(rightOperandType, leftOperandType, intType))
			_typeCheckingStack.push(boolType);
		else
			throw new TypesOfRelationalOperatorsMustBeIntException();
	}

	public void unaryMinusOperator() {
		ModuleEnvironment unaryMinusOperandType = _typeCheckingStack.pop();
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		
		if (unaryMinusOperandType.isSubtypeOf(intType))
			_typeCheckingStack.push(intType);
		else
			throw new TypeOfUnaryMinusOperatorMustBeIntException();
	}

	public void binaryMathematicalOperator() {
		ModuleEnvironment rightOperandType = _typeCheckingStack.pop();
		ModuleEnvironment leftOperandType = _typeCheckingStack.pop();
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		
		if (haveSameType(rightOperandType, leftOperandType, intType))
			_typeCheckingStack.push(intType);
		else
			throw new TypesOfBinaryMathematicalOperatorsMustBeIntException();
	}
	
}
