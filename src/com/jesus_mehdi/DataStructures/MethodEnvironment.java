package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;

public class MethodEnvironment extends Environment {

	private String _returnTypeName;
	
	public void setReturnType(String returnTypeName) {
		_returnTypeName = returnTypeName;
	}
	
	public String getReturnTypeName() {
		return _returnTypeName;
	}
	
	public int getAllMemeberCount() {
		return _symbolTable.getSize();
	}
	
	public ArrayList<MemberSymbolTableRow> getAllMemberRows() {
		return _symbolTable.getAllMemberRows();
	}
	
	public MemberSymbolTableRow getMemberRowByName(String memberName) {
		return (MemberSymbolTableRow)_symbolTable.getRow(memberName);
	}

}
