package com.jesus_mehdi.TypeCheckingHandlers.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.AccessingNonArrayVariableWithIndexException;
import com.jesus_mehdi.Exceptions.ArrayIndexTypeMustBeIntException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;

public class ArrayIndexTypeCheckingException extends TypeCheckerTest {

	@Test
	public void shouldPushArrayVariableTypeToTypeCheckingStack() {
		ApplicationMainSymbolTable.init();
		MethodEnvironment currentEnvironment = new MethodEnvironment();
		Current.setCurrentScope(currentEnvironment);
		_typeChecker.returnToCurrentScope();
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = "testArray";
		memberRow.Type = "int";
		memberRow.ArraySize = 2;
		currentEnvironment.addRow(memberRow);
		
		_typeChecker.fetchVariableAndCheckForBeingArray("testArray");
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("int", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = AccessingNonArrayVariableWithIndexException.class)
	public void shouldThrowExceptionWhenAccessingNonArrayVariableWithIndex() {
		MethodEnvironment currentEnvironment = new MethodEnvironment();
		Current.setCurrentScope(currentEnvironment);
		_typeChecker.returnToCurrentScope();
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = "testNonArray";
		memberRow.Type = "int";
		currentEnvironment.addRow(memberRow);
		
		_typeChecker.fetchVariableAndCheckForBeingArray("testNonArray");
	}
	
	@Test
	public void shouldCheckWhetherArrayIndexIsInt() {
		ApplicationMainSymbolTable.init();
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		_typeChecker.pushType(intType);
		
		_typeChecker.checkArrayIndexType();
	}
	
	@Test
	public void shouldThrowExceptionWhenArrayIndexIsNotInt() {
		ApplicationMainSymbolTable.init();
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		_typeChecker.pushType(intType);
		ModuleEnvironment stringType = ApplicationMainSymbolTable.getModuleByName("string");
		_typeChecker.pushType(stringType);
		
		try {
			_typeChecker.checkArrayIndexType();
			fail("should have thrown ArrayIndexTypeMustBeIntException");
		}
		catch(ArrayIndexTypeMustBeIntException ex) { }
		assertEquals(0, _typeChecker.getTypeCheckingStackSize());
	}
	
}
