package com.jesus_mehdi.DataStructures;

public class MethodEnvironment extends Environment {

	private String _returnTypeName;
	
	public void setReturnType(String returnTypeName) {
		_returnTypeName = returnTypeName;
	}
	
	public String getReturnTypeName() {
		return _returnTypeName;
	}

}
