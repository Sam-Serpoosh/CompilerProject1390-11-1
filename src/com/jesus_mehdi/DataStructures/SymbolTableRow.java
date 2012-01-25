package com.jesus_mehdi.DataStructures;

public class SymbolTableRow {

	public String Name;
	public String Type;
	public int Offset;
	public int ArraySize;
	
	public SymbolTableRow() {
		ArraySize = 0;
	}
	
	public boolean isArray() {
		return ArraySize > 0;
	}
	
}
