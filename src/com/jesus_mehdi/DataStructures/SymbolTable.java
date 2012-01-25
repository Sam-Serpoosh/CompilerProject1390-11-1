package com.jesus_mehdi.DataStructures;

import java.util.HashMap;

public class SymbolTable {
	private HashMap<String, SymbolTableRow> _rows;
	
	public SymbolTable() {
		_rows = new HashMap<String, SymbolTableRow>();
	}
	
	public void addRow(SymbolTableRow row) {
		if (_rows.containsKey(row.Name))
			concatSignatureToExistedMethod(row);
		else
			_rows.put(row.Name, row);
	}

	private void concatSignatureToExistedMethod(SymbolTableRow row) {
		MethodSymbolTableRow methodRow = (MethodSymbolTableRow)_rows.get(row.Name);
		MethodSymbolTableRow newMethodRow = (MethodSymbolTableRow)row;
		methodRow.addSignature(newMethodRow.getFirstSignature());
	}
	
	public SymbolTableRow getRow(String rowName) {
		return _rows.get(rowName);
	}
	
	public boolean rowAlreadyExisted(SymbolTableRow row) {
		return _rows.containsKey(row.Name);
	}
	
	public HashMap<String, SymbolTableRow> getAllRows() {
		return _rows;
	}
	
}
