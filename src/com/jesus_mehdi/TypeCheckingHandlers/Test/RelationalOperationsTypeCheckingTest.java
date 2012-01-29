package com.jesus_mehdi.TypeCheckingHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.TypesOfEqualityRelationOperatorsMustBeSameBaseTypesException;
import com.jesus_mehdi.Exceptions.TypesOfRelationalOperatorsMustBeIntException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class RelationalOperationsTypeCheckingTest extends TypeCheckerTest {

	@Test
	public void shouldCheckTypesOfEqualityRelationsShouldBeSame() {
		ModuleEnvironment leftIntOperandType = new ModuleEnvironment();
		leftIntOperandType.setName("int");
		ModuleEnvironment rightIntOperandType = new ModuleEnvironment();
		rightIntOperandType.setName("int");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(leftIntOperandType);
		_typeChecker.pushType(rightIntOperandType);
		_typeChecker.equalityRelationOperators();
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("bool", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = TypesOfEqualityRelationOperatorsMustBeSameBaseTypesException.class)
	public void shouldThrowExceptionWhenTypesOfEqualityRelationsAreNotSame() {
		ModuleEnvironment leftIntOperandType = new ModuleEnvironment();
		leftIntOperandType.setName("int");
		ModuleEnvironment rightStringOperandType = new ModuleEnvironment();
		rightStringOperandType.setName("string");
		ApplicationMainSymbolTable.init();
		
		_typeChecker.pushType(leftIntOperandType);
		_typeChecker.pushType(rightStringOperandType);
		_typeChecker.equalityRelationOperators();
	}
	
	@Test
	public void shouldCheckOperandsTypesOfRelationalOperatorsShouldBeInt() {
		ModuleEnvironment leftIntOperandType = new ModuleEnvironment();
		leftIntOperandType.setName("int");
		ModuleEnvironment rightIntOperandType = new ModuleEnvironment();
		rightIntOperandType.setName("int");
		ApplicationMainSymbolTable.init();
			
		_typeChecker.pushType(leftIntOperandType);
		_typeChecker.pushType(rightIntOperandType);
		_typeChecker.relationalOperator();
			
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("bool", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = TypesOfRelationalOperatorsMustBeIntException.class)
	public void shouldThrowExceptionWhenTypesOfRelationalOperatorsAreNotInt() {
		ModuleEnvironment leftIntOperandType = new ModuleEnvironment();
		leftIntOperandType.setName("int");
		ModuleEnvironment rightStringOperandType = new ModuleEnvironment();
		rightStringOperandType.setName("string");
		ApplicationMainSymbolTable.init();
			
		_typeChecker.pushType(leftIntOperandType);
		_typeChecker.pushType(rightStringOperandType);
		_typeChecker.relationalOperator();
	}
	
}
