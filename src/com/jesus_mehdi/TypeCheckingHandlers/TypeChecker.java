package com.jesus_mehdi.TypeCheckingHandlers;

import java.util.ArrayList;
import java.util.Stack;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.Environment;
import com.jesus_mehdi.DataStructures.FrameModuleEnvironment;
import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.Exceptions.AccessingNonArrayVariableWithIndexException;
import com.jesus_mehdi.Exceptions.ArrayIndexTypeMustBeIntException;
import com.jesus_mehdi.Exceptions.ConditionExpressionMustBeBooleanException;
import com.jesus_mehdi.Exceptions.CreationIsApplicableForNonBaseTypesException;
import com.jesus_mehdi.Exceptions.ReadAndWriteIsApplicableForBaseTypesException;
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
	private Environment _instanceEnvironment;
	private Environment _currentContainerEnvironment;
	
	public TypeChecker() {
		_typeCheckingStack = new Stack<ModuleEnvironment>();
		_tokenizer = new Tokenizer();
		_currentContainerEnvironment = Current.getScope();
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
	
	public Environment getInstanceEnvironment() {
		return _instanceEnvironment;
	}
	
	public Environment getCurrentContainerEnvironment() {
		return _currentContainerEnvironment;
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
	
	public void setArrayInputId(TokenStream input) {
		String variableName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		fetchVariableAndCheckForBeingArray(variableName);
	}

	public void fetchVariableAndCheckForBeingArray(String variableName) {
		Environment currentEnvironment = _currentContainerEnvironment;
		MemberSymbolTableRow memberRow = currentEnvironment.getVariableMemberRow(variableName);
		if (memberRow.isArray())
			_typeCheckingStack.push(currentEnvironment.getVariableType(variableName));
		else
			throw new AccessingNonArrayVariableWithIndexException();
	}
	
	public void fetchVariableTypeAndPutItIntoTypeCheckingStack(String variableName) {
		Environment currentEnvironment = _currentContainerEnvironment;
		_typeCheckingStack.push(currentEnvironment.getVariableType(variableName));
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

	public void conditionExpressionShouldBeBoolean() {
		ModuleEnvironment conditionExpressionType = _typeCheckingStack.pop();
		ModuleEnvironment boolType = ApplicationMainSymbolTable.getModuleByName("bool");
		
		if (conditionExpressionType.isSubtypeOf(boolType) == false)
			throw new ConditionExpressionMustBeBooleanException();
	}

	public void checkArrayIndexType() {
		ModuleEnvironment arrayIndexType = _typeCheckingStack.pop();
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		
		if (arrayIndexType.isSubtypeOf(intType) == false) {
			_typeCheckingStack.pop();
			throw new ArrayIndexTypeMustBeIntException();
		}
	}

	public void checkValidityOfIdForRead() {
		if (isSubTypeOfBaseTypes() == false)
			throw new ReadAndWriteIsApplicableForBaseTypesException();
	}

	public void checkValidityOfIdForWrite() {
		if (isSubTypeOfBaseTypes() == false)
			throw new ReadAndWriteIsApplicableForBaseTypesException();
	}
	
	private boolean isSubTypeOfBaseTypes() {
		ModuleEnvironment variableType = _typeCheckingStack.pop();
		ModuleEnvironment boolType = ApplicationMainSymbolTable.getModuleByName("bool");
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		ModuleEnvironment stringType = ApplicationMainSymbolTable.getModuleByName("string");
		
		return variableType.isSubtypeOf(boolType) || variableType.isSubtypeOf(intType) ||
			variableType.isSubtypeOf(stringType);
	}

	public void checkValidityOfIdForCreation() {
		if (isSubTypeOfBaseTypes() == true)
			throw new CreationIsApplicableForNonBaseTypesException();
	}

	public void setMethodInputId(TokenStream input) {
		String methodName = _tokenizer.getSpecificToken((CommonTokenStream)input, _tokenizer.LAST_TOKEN);
		fetchMethodRowAndPushFrameEnvironment(methodName);
	}

	public void fetchMethodRowAndPushFrameEnvironment(String methodName) {
		Environment currentEnvironment = _currentContainerEnvironment;
		currentEnvironment.getMethodRow(methodName);
		FrameModuleEnvironment methodNameEnvironment = new FrameModuleEnvironment();
		methodNameEnvironment.setName(methodName);
		_typeCheckingStack.push(methodNameEnvironment);
	}

	public void pushParameter() { }

	public void endMethodCall() {
		ArrayList<ModuleEnvironment> parameterTypes = new ArrayList<ModuleEnvironment>();
		String calledMethodName = fetchParameteresAndMethodName(parameterTypes);
		
		Signature calledMethodSignature = fetchCalledMethodSignature(parameterTypes, calledMethodName);
		
		ModuleEnvironment methodReturnType = ApplicationMainSymbolTable.getModuleByName(
				calledMethodSignature.getReturnType());
		_typeCheckingStack.push(methodReturnType);
	}

	private Signature fetchCalledMethodSignature(
			ArrayList<ModuleEnvironment> parameterTypes, String calledMethodName) {
		Signature signature = createSignature(parameterTypes);
		Environment currentEnvironment = _currentContainerEnvironment;
		Signature calledMethodSignature = currentEnvironment.getMethodRowWithSpecifiedSignature(
				calledMethodName, signature);
		return calledMethodSignature;
	}
	
	private String fetchParameteresAndMethodName(ArrayList<ModuleEnvironment> parameterTypes) {
		ModuleEnvironment parameterType = _typeCheckingStack.pop();
		while((parameterType instanceof FrameModuleEnvironment) == false) {
			parameterTypes.add(0, parameterType);
			parameterType = _typeCheckingStack.pop();
		}
		
		String calledMethodName = parameterType.getName();
		return calledMethodName;
	}

	private Signature createSignature(ArrayList<ModuleEnvironment> parameterTypes) {
		Signature signature = new Signature();
		for (ModuleEnvironment parameter : parameterTypes)
			signature.addArgument("", parameter.getName());
		
		return signature;
	}

	public void setInstanceScope() {
		ModuleEnvironment instanceType = _typeCheckingStack.pop();
		_instanceEnvironment = instanceType;
	}
	
	public void changeToInstanceScope() {
		if (_instanceEnvironment == null)
			_instanceEnvironment = Current.getScope();
		_currentContainerEnvironment = _instanceEnvironment;
	}

	public void returnToCurrentScope() {
		_currentContainerEnvironment = Current.getScope();
	}
	
}
