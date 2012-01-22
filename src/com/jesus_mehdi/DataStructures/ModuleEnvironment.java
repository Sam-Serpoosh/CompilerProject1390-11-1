package com.jesus_mehdi.DataStructures;

public class ModuleEnvironment extends Environment {

	private String _name;
	private String _parentName;
	
	public ModuleEnvironment() {
		_parentScope = null;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}

	public void setParentName(String parentName) {
		_parentName = parentName;
	}

	public String getParentName() {
		return _parentName;
	}
	
}
