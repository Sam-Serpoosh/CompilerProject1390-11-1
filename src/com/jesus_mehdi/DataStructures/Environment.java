package com.jesus_mehdi.DataStructures;

import com.jesus_mehdi.Exceptions.MethodWithSpecifiedSignatureNotExistedException;
import com.jesus_mehdi.Exceptions.UndefinedIdentifierException;
import com.jesus_mehdi.Exceptions.UndefinedMethodException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public abstract class Environment {
	
	protected Environment _parentScope;
	protected SymbolTable _symbolTable;
	protected String _name;
	
	private int _currentOffset;
	
	public Environment() {
		_symbolTable = new SymbolTable();
		_currentOffset = 0;
	}
	
	public SymbolTable getSymbolTable() {
		return _symbolTable;
	}
	
	public void setSymbolTable(SymbolTable symbolTable) {
		_symbolTable = symbolTable;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	public Environment getParentScope() {
		return _parentScope;
	}
	
	public void setParentScope(Environment parentEnvironment) {
		_parentScope = parentEnvironment;
	}
	
	public int getModuleSize() {
		return _currentOffset;
	}
	
	public void addRow(SymbolTableRow row) {
		row.setOffset(_currentOffset);
		_symbolTable.addRow(row);
		_currentOffset += row.getSize();
	}
	
	public SymbolTableRow getRow(String rowName) {
		return _symbolTable.getRow(rowName);
	}
	
	public boolean rowAlreadyExisted(SymbolTableRow row) {
		return _symbolTable.rowAlreadyExisted(row);
	}
	
	public boolean rowAlreadyExisted(String rowName) {
		return _symbolTable.rowAlreadyExisted(rowName);
	}
	
	public ModuleEnvironment getVariableType(String variableName) {
		String variableTypeName = getVariableMemberRow(variableName).Type;
		return ApplicationMainSymbolTable.getModuleByName(variableTypeName);
	}
	
	public MemberSymbolTableRow getVariableMemberRow(String variableName) {
		if (rowAlreadyExisted(variableName)) {
			SymbolTableRow row = _symbolTable.getRow(variableName);
			if (row instanceof MemberSymbolTableRow) {
				MemberSymbolTableRow memberRow = (MemberSymbolTableRow)row;
				return memberRow;
			}
		}
		
		if (getParentScope() == null)
			throw new UndefinedIdentifierException();
		
		Environment parentModule = getParentScope();
		return parentModule.getVariableMemberRow(variableName);
	}
	
	public MethodSymbolTableRow getMethodRow(String methodName) {
		if (rowAlreadyExisted(methodName)) {
			SymbolTableRow row = _symbolTable.getRow(methodName);
			if (row instanceof MethodSymbolTableRow) {
				MethodSymbolTableRow methodRow = (MethodSymbolTableRow)row;
				return methodRow;
			}
		}
		
		if (getParentScope() == null)
			throw new UndefinedMethodException();
		
		Environment parentModule = getParentScope();
		return parentModule.getMethodRow(methodName);
	}
	
	public Signature getMethodRowWithSpecifiedSignature(String methodName, Signature signature) {
		MethodSymbolTableRow methodRow = getMethodRow(methodName);
		for (Signature methodSignature : methodRow.getAllSignatures())
			if (signature.isSubSignatureOf(methodSignature))
				return methodSignature;
		
		if (getParentScope() == null)
			throw new MethodWithSpecifiedSignatureNotExistedException();
		
		Environment parentEnvironment = getParentScope();
		return parentEnvironment.getMethodRowWithSpecifiedSignature(methodName, signature);
	}
	
}
