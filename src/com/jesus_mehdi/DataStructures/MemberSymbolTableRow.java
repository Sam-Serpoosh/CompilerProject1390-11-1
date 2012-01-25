package com.jesus_mehdi.DataStructures;

public class MemberSymbolTableRow extends SymbolTableRow{

	public int Offset;
	public int ArraySize;
	
	private OffsetFactory _offsetFactory;
	
	public MemberSymbolTableRow() {
		_offsetFactory = new OffsetFactory();
		ArraySize = 0;
	}
	
	public boolean isArray() {
		return ArraySize > 0;
	}

	@Override
	public int getSize() {
		if (isArray())
			return _offsetFactory.getSizeOf(Type) * ArraySize;
		
		return _offsetFactory.getSizeOf(Type);
	}

	@Override
	public void setOffset(int offset) {
		Offset = offset;
	}
	
}
