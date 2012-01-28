package com.jesus_mehdi.DataStructures;

import com.jesus_mehdi.Exceptions.UndefinedIdentifierException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public abstract class Environment {
	
	protected Environment _parentScope;
	protected SymbolTable _symbolTable;
	
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
		if (rowAlreadyExisted(variableName)) {
			SymbolTableRow row = _symbolTable.getRow(variableName);
			if (row instanceof MemberSymbolTableRow) {
				MemberSymbolTableRow memberRow = (MemberSymbolTableRow)row;
				return ApplicationMainSymbolTable.getModuleByName(memberRow.Type);
			}
		}
		
		if (getParentScope() == null)
			throw new UndefinedIdentifierException();
		
		Environment parentModule = getParentScope();
		return parentModule.getVariableType(variableName);
	}
	
}
