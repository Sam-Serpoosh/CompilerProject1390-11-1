package com.jesus_mehdi.TypeCheckingHandlers;

public class TypeCheckerFactory {

	private static TypeChecker _typeChecker;
	
	public static void createTypeChecker() {
		_typeChecker = new TypeChecker();
	}
	
	public static TypeChecker getTypeChecker() {
		return _typeChecker;
	}
	
}
