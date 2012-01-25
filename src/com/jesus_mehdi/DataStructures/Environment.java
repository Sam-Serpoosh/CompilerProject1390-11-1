package com.jesus_mehdi.DataStructures;

public abstract class Environment {
	
	protected Environment _parentScope;
	protected SymbolTable _symbolTable;
	
	private int _currentOffset;
	private OffsetFactory _offsetFactory;
	
	public Environment() {
		_symbolTable = new SymbolTable();
		_currentOffset = 0;
		_offsetFactory = new OffsetFactory();
	}
	
	public SymbolTable getSymbolTable() {
		return _symbolTable;
	}

	public Environment getParentScope() {
		return _parentScope;
	}
	
	public int getModuleSize() {
		return _currentOffset;
	}
	
	public void addRow(SymbolTableRow row) {
		row.Offset = _currentOffset;
		_symbolTable.addRow(row);
		_currentOffset += _offsetFactory.getSize(row);
	}
	
	public SymbolTableRow getRow(String rowName) {
		return _symbolTable.getRow(rowName);
	}
	
	public boolean rowAlreadyExisted(SymbolTableRow row) {
		return _symbolTable.rowAlreadyExisted(row);
	}
	
}
