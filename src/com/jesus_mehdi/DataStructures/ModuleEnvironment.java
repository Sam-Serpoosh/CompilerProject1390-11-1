package com.jesus_mehdi.DataStructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;

import com.jesus_mehdi.Exceptions.ModuleContainsTwoMainMethodsException;
import com.jesus_mehdi.Exceptions.UndefinedMethodException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class ModuleEnvironment extends Environment {

	private String _name;
	private String _parentName;
	private static ArrayList<SimpleEntry<String, MethodEnvironment>> _allMethods = new 
		ArrayList<SimpleEntry<String,MethodEnvironment>>();
	
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

	public void addMethodEnvironment(MethodEnvironment methodEnvironment) {
		SimpleEntry<String, MethodEnvironment> methodEnvironmentEntry = 
			new SimpleEntry<String, MethodEnvironment>(methodEnvironment.getName(), methodEnvironment);
		
		_allMethods.add(methodEnvironmentEntry);
	}

	public ArrayList<SimpleEntry<String, MethodEnvironment>> getMethodEnvironmentByName(String methodName) {
		if (containsMethodEnvironment(methodName) == false)
			throw new UndefinedMethodException();
		
		return getMethodEnvironmentsFor(methodName);
	}

	public ArrayList<SimpleEntry<String, MethodEnvironment>> getAllMethodEnvironments() {
		return _allMethods;
	}

	public void clearAllMethodEnvironments() {
		_allMethods.clear();
	}
	
	private boolean containsMethodEnvironment(String methodName) {
		for (SimpleEntry<String, MethodEnvironment> methodEnvironment : _allMethods)
			if (methodEnvironment.getKey().equals(methodName))
				return true;
		
		return false;
	}
	
	private ArrayList<SimpleEntry<String, MethodEnvironment>> getMethodEnvironmentsFor(String methodName) {
		ArrayList<SimpleEntry<String, MethodEnvironment>> sameNameMethodEnvironments = new 
			ArrayList<SimpleEntry<String,MethodEnvironment>>();
		
		for (SimpleEntry<String, MethodEnvironment> methodEnvironment : _allMethods)
			if (methodEnvironment.getKey().equals(methodName))
				sameNameMethodEnvironments.add(methodEnvironment);
		
		return sameNameMethodEnvironments;
	}
	
}
