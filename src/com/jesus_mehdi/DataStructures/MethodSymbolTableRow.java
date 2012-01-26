package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;

public class MethodSymbolTableRow extends SymbolTableRow {

	private ArrayList<Signature> _signatures;
	private boolean _isVirtual;
	
	public MethodSymbolTableRow() {
		_signatures = new ArrayList<Signature>();
		_isVirtual = false;
	}
	
	public void setVirtual() {
		_isVirtual = true;
	}
	
	public boolean isVirtual() {
		return _isVirtual;
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
