package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;
import java.util.HashMap;

import com.jesus_mehdi.Exceptions.MethodsDeclaredWithSameNameWhichAtLeastOneOfThemIsVirtualException;

public class SymbolTable {
	private HashMap<String, SymbolTableRow> _rows;
	
	public SymbolTable() {
		_rows = new HashMap<String, SymbolTableRow>();
	}
	
	public void addRow(SymbolTableRow row) {
		if (_rows.containsKey(row.Name)) {
			MethodSymbolTableRow methodRow = (MethodSymbolTableRow)_rows.get(row.Name);
			MethodSymbolTableRow newMethodRow = (MethodSymbolTableRow)row;
			if (methodRow.isVirtual() || newMethodRow.isVirtual())
				throw new MethodsDeclaredWithSameNameWhichAtLeastOneOfThemIsVirtualException();
			concatSignatureToExistedMethod(row);
		}
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
		return rowAlreadyExisted(row.Name);
	}
	
	public boolean rowAlreadyExisted(String rowName) {
		return _rows.containsKey(rowName);
	}
	
	public HashMap<String, SymbolTableRow> getAllRows() {
		return _rows;
	}
	
	public ArrayList<MemberSymbolTableRow> getAllMemberRows() {
		ArrayList<MemberSymbolTableRow> allMemberRows = new ArrayList<MemberSymbolTableRow>();
		for (SymbolTableRow row : _rows.values())
			if (row instanceof MemberSymbolTableRow)
				allMemberRows.add((MemberSymbolTableRow)row);
		
		return allMemberRows;
	}
	
	public ArrayList<MethodSymbolTableRow> getAllMethodRows() {
		ArrayList<MethodSymbolTableRow> allMethodRows = new ArrayList<MethodSymbolTableRow>();
		for (SymbolTableRow row : _rows.values())
			if (row instanceof MethodSymbolTableRow)
				allMethodRows.add((MethodSymbolTableRow)row);
		
		return allMethodRows;
	}
	
}
