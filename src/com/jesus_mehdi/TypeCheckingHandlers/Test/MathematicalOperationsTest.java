package com.jesus_mehdi.TypeCheckingHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.TypeOfUnaryMinusOperatorMustBeIntException;
import com.jesus_mehdi.Exceptions.TypesOfBinaryMathematicalOperatorsMustBeIntException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class MathematicalOperationsTest extends TypeCheckerTest {

	@Test
	public void shouldCheckTypesOfBinaryMathematicalOperatorsShouldBeInt() {
		ModuleEnvironment leftIntOperandType = new ModuleEnvironment();
		leftIntOperandType.setName("int");
		ModuleEnvironment rightIntOperandType = new ModuleEnvironment();
		rightIntOperandType.setName("int");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(leftIntOperandType);
		_typeChecker.pushType(rightIntOperandType);
		_typeChecker.binaryMathematicalOperator();
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("int", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = TypesOfBinaryMathematicalOperatorsMustBeIntException.class)
	public void shouldThrowExceptionWhenTypesOfBinaryMathematicalOperatorsAreNotInt() {
		ModuleEnvironment leftIntOperandType = new ModuleEnvironment();
		leftIntOperandType.setName("int");
		ModuleEnvironment rightStringOperandType = new ModuleEnvironment();
		rightStringOperandType.setName("string");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(leftIntOperandType);
		_typeChecker.pushType(rightStringOperandType);
		_typeChecker.binaryMathematicalOperator();
	}
	
	@Test
	public void shouldCheckOperandTypeOfUnaryMinusOperatorShouldBeInt() {
		ModuleEnvironment unaryMinusOperandType = new ModuleEnvironment();
		unaryMinusOperandType.setName("int");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(unaryMinusOperandType);
		_typeChecker.unaryMinusOperator();
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("int", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = TypeOfUnaryMinusOperatorMustBeIntException.class)
	public void shouldThrowExceptionWhenOperandTypeOfUnaryMinusOperatorIsNotInt() {
		ModuleEnvironment unaryMinusOperandType = new ModuleEnvironment();
		unaryMinusOperandType.setName("bool");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(unaryMinusOperandType);
		
		_typeChecker.unaryMinusOperator();
	}
	
}
