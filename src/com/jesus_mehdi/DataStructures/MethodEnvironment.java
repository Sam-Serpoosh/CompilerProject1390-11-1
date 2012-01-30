package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;

public class MethodEnvironment extends Environment {

	private String _returnTypeName;
	private boolean _returnSeen;
	
	public MethodEnvironment() {
		_returnSeen = false;
	}
	
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

	public void SetReturnSeen(boolean returnSeen) {
		_returnSeen = returnSeen;
	}

	public boolean hasReturnSeen() {
		return _returnSeen;
	}

}
