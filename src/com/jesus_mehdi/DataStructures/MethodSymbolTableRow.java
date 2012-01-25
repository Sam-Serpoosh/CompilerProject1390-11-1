package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;

public class MethodSymbolTableRow extends SymbolTableRow {

	private ArrayList<Signature> _signatures;
	
	public MethodSymbolTableRow() {
		_signatures = new ArrayList<Signature>();
	}
	
	public void addSignature(Signature signature) {
		_signatures.add(signature);
	}
	
	public ArrayList<Signature> getAllSignatures() {
		return _signatures;
	}
	
	public Signature getFirstSignature() {
		return _signatures.get(0);
	}
	
	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public void setOffset(int offset) { }

}
