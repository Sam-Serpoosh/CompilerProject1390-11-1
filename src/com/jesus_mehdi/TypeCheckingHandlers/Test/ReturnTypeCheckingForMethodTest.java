package com.jesus_mehdi.TypeCheckingHandlers.Test;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.ReturnTypeMustBeSubTypeOfMethodReturnType;
import com.jesus_mehdi.Exceptions.UsingReturnOutOfMethodException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;

public class ReturnTypeCheckingForMethodTest extends TypeCheckerTest {

	@Test(expected = UsingReturnOutOfMethodException.class)
	public void shouldThrowExceptionWhenReturnStatementIsNotInMethod() {
		ModuleEnvironment currentModule = new ModuleEnvironment();
		Current.setCurrentScope(currentModule);
		_typeChecker.returnSeen();
	}
	
	@Test(expected = UsingReturnOutOfMethodException.class)
	public void shouldThrowExceptionWhenCurrentEnvironmentIsNullAndReturnHasBeenSeen() {
		Current.setCurrentScope(null);
		_typeChecker.returnSeen();
	}
	
	@Test(expected = ReturnTypeMustBeSubTypeOfMethodReturnType.class)
	public void shouldThrowExceptionWhenReturnedValueTypeIsNotSubTypeOfMethodReturnType() {
		ApplicationMainSymbolTable.init();
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		methodEnvironment.setReturnType("int");
		ModuleEnvironment stringType = ApplicationMainSymbolTable.getModuleByName("string");
		_typeChecker.pushType(stringType);
		
		_typeChecker.checkReturnType(methodEnvironment);
	}
	
	@Test
	public void returnedValueTypeShouldBeSubTypeOfMethodReturnType() {
		ApplicationMainSymbolTable.init();
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		methodEnvironment.setReturnType("int");
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		_typeChecker.pushType(intType);
		
		_typeChecker.checkReturnType(methodEnvironment);
	}
	
}
