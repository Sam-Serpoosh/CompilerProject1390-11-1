package com.jesus_mehdi.DataStructures;

public abstract class Environment {
	
	protected Environment _parentScope;
	protected SymbolTable _symbolTable;
	
	public Environment() {
		_symbolTable = new SymbolTable();
	}

	public Environment getParentScope() {
		return _parentScope;
	}
	
}
