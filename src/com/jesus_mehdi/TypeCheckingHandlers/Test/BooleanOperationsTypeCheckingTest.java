package com.jesus_mehdi.TypeCheckingHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.TypesOfBooleanOperatorsMustBeBooleanException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class BooleanOperationsTypeCheckingTest extends TypeCheckerTest {

	@Test
	public void shouldCheckTypesForBooleanOperators() {
		ModuleEnvironment leftBoolOperandType = new ModuleEnvironment();
		leftBoolOperandType.setName("bool");
		ModuleEnvironment rightBoolOperandType = new ModuleEnvironment();
		rightBoolOperandType.setName("bool");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(leftBoolOperandType);
		_typeChecker.pushType(rightBoolOperandType);
		_typeChecker.andOperator();
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("bool", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = TypesOfBooleanOperatorsMustBeBooleanException.class)
	public void shouldThrowExceptionWhenOperandsTypesOfBooleanOperatorsAreNotBoolean() {
		ModuleEnvironment leftBoolOperandType = new ModuleEnvironment();
		leftBoolOperandType.setName("bool");
		ModuleEnvironment rightBoolOperandType = new ModuleEnvironment();
		rightBoolOperandType.setName("int");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(leftBoolOperandType);
		_typeChecker.pushType(rightBoolOperandType);
		
		_typeChecker.orOperator();
	}
	
	@Test
	public void shouldCheckOperandTypeOfNotOperatorShouldBeBoolean() {
		ModuleEnvironment notOperandType = new ModuleEnvironment();
		notOperandType.setName("bool");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(notOperandType);
		_typeChecker.notOperator();
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("bool", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = TypesOfBooleanOperatorsMustBeBooleanException.class)
	public void shouldThrowExceptionWhenOperandTypeOfNotOperatorIsNotBoolean() {
		ModuleEnvironment notOperandType = new ModuleEnvironment();
		notOperandType.setName("int");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(notOperandType);
		
		_typeChecker.notOperator();
	}
	
}
