package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;
import java.util.Collection;

import com.jesus_mehdi.Exceptions.ModuleContainsTwoMainMethodsException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

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
	
	public ModuleEnvironment getParentRoot() {
		ModuleEnvironment parentModule = this;
		while (parentModule.getParentScope() != null)
			parentModule = (ModuleEnvironment)parentModule.getParentScope();
		
		return parentModule;
	}
	
	public ArrayList<ModuleEnvironment> getAllChildren() {
		Collection<ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules().values();
		ArrayList<ModuleEnvironment> children = new ArrayList<ModuleEnvironment>();
		for (ModuleEnvironment module : allModules)
			if (module.getParentName().equals(getName()))
				children.add(module);
		
		return children;
	}
	
}
