package com.jesus_mehdi.TypeCheckingHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.TypeMismatchException;
import com.jesus_mehdi.Exceptions.TypesOfBooleanOperatorsMustBeBooleanException;
import com.jesus_mehdi.Exceptions.UndefinedIdentifierException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.MemberHandler;
import com.jesus_mehdi.SemanticRulesHandlers.MethodHandler;
import com.jesus_mehdi.TypeCheckingHandlers.TypeChecker;

public class TypeCheckerTest {
	
	private TypeChecker _typeChecker;
	
	@Before
	public void setUp() {
		_typeChecker = new TypeChecker();
	}

	@Test
	public void shouldCheckTypesForAssignment_WhenRightValueIsInTheSameScope() {
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		Current.setCurrentScope(methodEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		declareMemberRowAndAddItToCurrentScope(memberHandler, "leftValueInt", "int");
		declareMemberRowAndAddItToCurrentScope(memberHandler, "rightValueInt", "int");
		
		ApplicationMainSymbolTable.init();
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("leftValueInt");
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("rightValueInt");
		
		_typeChecker.assignmentOperator();
	}
	
	@Test(expected = TypeMismatchException.class)
	public void shoudThrowExceptionWhenTypeMismatchOccuresInAssignment_WhenRightValueIsInSameScope() {
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		Current.setCurrentScope(methodEnvironment);
		MemberHandler memberHandler = new MemberHandler();
		declareMemberRowAndAddItToCurrentScope(memberHandler, "leftValueInt", "int");
		declareMemberRowAndAddItToCurrentScope(memberHandler, "rightValueInt", "string");
		
		ApplicationMainSymbolTable.init();
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("leftValueInt");
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("rightValueInt");
		
		_typeChecker.assignmentOperator();
	}
	
	@Test
	public void shouldCheckTypesForAssignment_WhenRightValueIsInImmediateParentScope() {
		ModuleEnvironment parentModule = createModuleAndSetItToCurrentScope("ParentModule");
		MemberHandler memberHandler = new MemberHandler();
		declareMemberRowAndAddItToCurrentScope(memberHandler, "rightValueInt", "int");
		
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		methodEnvironment.setParentScope(parentModule);
		Current.setCurrentScope(methodEnvironment);
		memberHandler = new MemberHandler();
		declareMemberRowAndAddItToCurrentScope(memberHandler, "leftValueInt", "int");
		
		ApplicationMainSymbolTable.init();
		ApplicationMainSymbolTable.addModule(parentModule);
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("leftValueInt");
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("rightValueInt");
		
		_typeChecker.assignmentOperator();
	}
	
	@Test(expected = TypeMismatchException.class)
	public void shoudThrowExceptionWhenTypeMismatchOccuresInAssignment_WhenRightValueIsInImmediateParentScope() {
		ModuleEnvironment parentModule = createModuleAndSetItToCurrentScope("ParentModule");
		MemberHandler memberHandler = new MemberHandler();
		declareMemberRowAndAddItToCurrentScope(memberHandler, "rightValueInt", "string");
		
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		methodEnvironment.setParentScope(parentModule);
		Current.setCurrentScope(methodEnvironment);
		memberHandler = new MemberHandler();
		declareMemberRowAndAddItToCurrentScope(memberHandler, "leftValueInt", "int");
		
		ApplicationMainSymbolTable.init();
		ApplicationMainSymbolTable.addModule(parentModule);
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("leftValueInt");
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("rightValueInt");
		
		_typeChecker.assignmentOperator();
	}
	
	@Test(expected = UndefinedIdentifierException.class)
	public void shouldIgnoreMethodWithSameNameOfVariableInFetchingVariableTypeInScopeHierarchy() {
		ModuleEnvironment moduleEnvironment = createModuleAndSetItToCurrentScope("ParentModule");
		MethodHandler methodHandler = new MethodHandler();
		declareMethodRowAndAddItToCurrentScope(methodHandler, "rightValueInt");
		
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		methodEnvironment.setParentScope(moduleEnvironment);
		Current.setCurrentScope(methodEnvironment);
		MemberHandler memberHandler = new MemberHandler();
	
		declareMemberRowAndAddItToCurrentScope(memberHandler, "leftValueInt", "int");
		ApplicationMainSymbolTable.init();
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("leftValueInt");
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("rightValueInt");
		
		_typeChecker.assignmentOperator();
	}
	
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
	
	private void declareMemberRowAndAddItToCurrentScope(MemberHandler memberHandler, String variableName, String type) {
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = variableName;
		memberRow.Type = type;
		memberHandler.setMemberRow(memberRow);
		memberHandler.endMemberDeclaration();		
	}
	
	private void declareMethodRowAndAddItToCurrentScope(MethodHandler methodHandler, String methodName) {
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = methodName;
		methodHandler.setMethodRow(methodRow);
		methodHandler.endMethodDeclaration();
	}
	
	private ModuleEnvironment createModuleAndSetItToCurrentScope(String moduleName) {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		moduleEnvironment.setName(moduleName);
		Current.setCurrentScope(moduleEnvironment);
		
		return moduleEnvironment;
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
