package com.jesus_mehdi.TypeCheckingHandlers;

public class TypeCheckerFactory {

	private static TypeChecker _typeChecker;
	
	public static void createTypeChecker() {
	}
	
	public static TypeChecker getTypeChecker() {
		if (_typeChecker == null)
			_typeChecker = new TypeChecker();
		
		_typeChecker.resetCurrentContainerEnvironment();
		return _typeChecker;
	}
	
}
