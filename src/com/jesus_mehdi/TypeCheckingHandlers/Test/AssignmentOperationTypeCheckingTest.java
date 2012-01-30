package com.jesus_mehdi.TypeCheckingHandlers.Test;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.TypeMismatchException;
import com.jesus_mehdi.Exceptions.UndefinedIdentifierException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.MemberHandler;
import com.jesus_mehdi.SemanticRulesHandlers.MethodHandler;

public class AssignmentOperationTypeCheckingTest extends TypeCheckerTest {

	@Test
	public void shouldCheckTypesForAssignment_WhenRightValueIsInTheSameScope() {
		MethodEnvironment methodEnvironment = new MethodEnvironment();
		Current.setCurrentScope(methodEnvironment);
		_typeChecker.returnToCurrentScope();
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
		_typeChecker.returnToCurrentScope();
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
		_typeChecker.returnToCurrentScope();
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
		_typeChecker.returnToCurrentScope();
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
		_typeChecker.returnToCurrentScope();
		MemberHandler memberHandler = new MemberHandler();
	
		declareMemberRowAndAddItToCurrentScope(memberHandler, "leftValueInt", "int");
		ApplicationMainSymbolTable.init();
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("leftValueInt");
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("rightValueInt");
		
		_typeChecker.assignmentOperator();
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
	
}
