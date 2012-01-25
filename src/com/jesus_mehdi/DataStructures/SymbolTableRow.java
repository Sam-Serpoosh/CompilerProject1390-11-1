package com.jesus_mehdi.DataStructures;

public abstract class SymbolTableRow {

	public String Name;
	public String Type;
	
	public abstract int getSize();

	public abstract void setOffset(int offset);
	
}
