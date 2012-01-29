package com.jesus_mehdi.TypeCheckingHandlers.Test;

import org.junit.After;
import org.junit.Before;

import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.TypeCheckingHandlers.TypeChecker;

public class TypeCheckerTest {
	
	protected TypeChecker _typeChecker;
	
	@Before
	public void setUp() {
		_typeChecker = new TypeChecker();
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
		_typeChecker.clearTypeCheckingStack();
	}
	
}
