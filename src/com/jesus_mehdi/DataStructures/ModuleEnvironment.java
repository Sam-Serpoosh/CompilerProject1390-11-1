package com.jesus_mehdi.DataStructures;

import com.jesus_mehdi.Exceptions.ModuleContainsTwoMainMethodsException;

public class ModuleEnvironment extends Environment {

	private String _name;
	private String _parentName;
	
	private boolean _containsMainMethod;
	
	public ModuleEnvironment() {
		_parentScope = null;
		_containsMainMethod = false;
	}
	
	public void setContainsMainMethod() {
		if (alreadyContainsMainMethod())
			throw new ModuleContainsTwoMainMethodsException();
		
		_containsMainMethod = true;
	}
	
	public boolean alreadyContainsMainMethod() {
		return _containsMainMethod;
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
	
	public boolean isSubtypeOf(ModuleEnvironment module) {
		ModuleEnvironment parentModule = this;
		while(parentModule != null) {
			if (parentModule.getName().equals(module.getName()))
				return true;
			
			parentModule = (ModuleEnvironment)parentModule.getParentScope();
		}
			
		return false;
	}
	
}
