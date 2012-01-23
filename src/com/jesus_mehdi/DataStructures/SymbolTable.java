package com.jesus_mehdi.DataStructures;

import java.util.HashMap;

public class SymbolTable {
	private HashMap<String, SymbolTableRow> _rows;
	
	public SymbolTable() {
		_rows = new HashMap<String, SymbolTableRow>();
	}
	
	public void addRow(SymbolTableRow row) {
		_rows.put(row.Name, row);
	}
	
	public SymbolTableRow getRow(String rowName) {
		return _rows.get(rowName);
	}
	
	public boolean rowAlreadyExisted(SymbolTableRow row) {
		return _rows.containsKey(row.Name);
	}
}
