package com.jesus_mehdi.TypeCheckingHandlers.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.FrameModuleEnvironment;
import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.ErrorCheckings.PostFirstIterationHandler;
import com.jesus_mehdi.Exceptions.MethodWithSpecifiedSignatureNotExistedException;
import com.jesus_mehdi.Exceptions.UndefinedIdentifierException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;

public class MethodCallTypeCheckingTest extends TypeCheckerTest {
	
	@Test
	public void shouldPushFrameEnvironmentForMethod() {
		ModuleEnvironment currentEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(currentEnvironment);
		_typeChecker.returnToCurrentScope();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		currentEnvironment.addRow(methodRow);
	
		
		_typeChecker.fetchMethodRowAndPushFrameEnvironment("testMethod");
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertTrue(_typeChecker.getTypeAt(0) instanceof FrameModuleEnvironment);
	}
	
	@Test
	public void shouldCheckSignatureOfMethodCallInModulesHierarchy_WhenSignatureExistInSameModule() {
		ModuleEnvironment currentModule = new ModuleEnvironment();
		ApplicationMainSymbolTable.init();
		Current.setCurrentScope(currentModule);
		_typeChecker.returnToCurrentScope();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		addSignatureToMethodRow(methodRow, "testArg", "string", "int");
		currentModule.addRow(methodRow);
		_typeChecker.fetchMethodRowAndPushFrameEnvironment("testMethod");
		ModuleEnvironment stringType = ApplicationMainSymbolTable.getModuleByName("string");
		_typeChecker.pushType(stringType);
		
		
		_typeChecker.endMethodCall();
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("int", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test
	public void shouldCheckSignatureOfMethodCallInModulesHierarchy_WhenSignatureExistInImmediateParent() {
		setUpSuperAndSubModule();
		ModuleEnvironment parentModule = new ModuleEnvironment();
		ModuleEnvironment currentModule = new ModuleEnvironment();
		currentModule.setParentScope(parentModule);
		ApplicationMainSymbolTable.init();
		Current.setCurrentScope(currentModule);
		_typeChecker.returnToCurrentScope();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		Signature signature = createSignature("SuperModule", "firstArg", "string");
		signature.addArgument("secondArg", "SuperModule");
		methodRow.addSignature(signature);
		parentModule.addRow(methodRow);
		_typeChecker.fetchMethodRowAndPushFrameEnvironment("testMethod");
		ModuleEnvironment stringType = ApplicationMainSymbolTable.getModuleByName("string");
		_typeChecker.pushType(stringType);
		ModuleEnvironment subModule = ApplicationMainSymbolTable.getModuleByName("SubModule");
		_typeChecker.pushType(subModule);
		
		_typeChecker.endMethodCall();
		
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("SuperModule", _typeChecker.getTypeAt(0).getName());
	}
	
	@Test(expected = MethodWithSpecifiedSignatureNotExistedException.class)
	public void shouldThrowExceptionWhenMethodCalledWithNotDefinedSignature() {
		ModuleEnvironment currentModule = new ModuleEnvironment();
		ApplicationMainSymbolTable.init();
		Current.setCurrentScope(currentModule);
		_typeChecker.returnToCurrentScope();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		addSignatureToMethodRow(methodRow, "testArg", "string", "int");
		currentModule.addRow(methodRow);
		_typeChecker.fetchMethodRowAndPushFrameEnvironment("testMethod");
		ModuleEnvironment intType = ApplicationMainSymbolTable.getModuleByName("int");
		_typeChecker.pushType(intType);
		
		_typeChecker.endMethodCall();
	}
	
	@Test
	public void shouldChangeScopeForInstanceMember() {
		MemberSymbolTableRow variableRow = new MemberSymbolTableRow();
		variableRow.Name = "variable";
		variableRow.Type = "int";
		setUpModulesForUsingInstanceVariables(variableRow);

		_typeChecker.setInstanceScope();
		assertEquals("FirstModule", _typeChecker.getInstanceEnvironment().getName());
		_typeChecker.changeToInstanceScope();
		
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("variable");
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("int", _typeChecker.getTypeAt(0).getName());
		
		_typeChecker.returnToCurrentScope();
		assertEquals("SecondModule", _typeChecker.getCurrentContainerEnvironment().getName());
	}
	
	@Test
	public void shouldChangeScopeForInstanceMethod() {
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		Signature signature = new Signature("string");
		methodRow.addSignature(signature);
		setUpModulesForUsingInstanceVariables(methodRow);
		
		_typeChecker.setInstanceScope();
		assertEquals("FirstModule", _typeChecker.getInstanceEnvironment().getName());
		_typeChecker.changeToInstanceScope();
		
		_typeChecker.fetchMethodRowAndPushFrameEnvironment("testMethod");
		_typeChecker.endMethodCall();
		assertEquals(1, _typeChecker.getTypeCheckingStackSize());
		assertEquals("string", _typeChecker.getTypeAt(0).getName());
		
		_typeChecker.returnToCurrentScope();
		assertEquals("SecondModule", _typeChecker.getCurrentContainerEnvironment().getName());
	}
	
	@Test(expected = UndefinedIdentifierException.class)
	public void shouldThrowExceptionWhenAccessingNotExistedMember() {
		setUpModulesForUsingInstanceVariables(null);

		_typeChecker.setInstanceScope();
		assertEquals("FirstModule", _typeChecker.getInstanceEnvironment().getName());
		_typeChecker.changeToInstanceScope();
		
		_typeChecker.fetchVariableTypeAndPutItIntoTypeCheckingStack("variable");
	}
	
	private void setUpModulesForUsingInstanceVariables(SymbolTableRow row) {
		ModuleEnvironment firstModule = new ModuleEnvironment();
		firstModule.setName("FirstModule");
		ModuleEnvironment secondModule = new ModuleEnvironment();
		secondModule.setName("SecondModule");
		ApplicationMainSymbolTable.init();
		ApplicationMainSymbolTable.addModule(firstModule);
		ApplicationMainSymbolTable.addModule(secondModule);
		new PostFirstIterationHandler();
		Current.setCurrentScope(secondModule);
		_typeChecker.pushType(firstModule);
		if (row != null)
			firstModule.addRow(row);
		MemberSymbolTableRow instanceMember = new MemberSymbolTableRow();
		instanceMember.Name = "instanceMember";
		instanceMember.Type = "FirstModule";
		secondModule.addRow(instanceMember);
	}
	
	private void addSignatureToMethodRow(MethodSymbolTableRow methodRow, String argumentName, 
			String argumentType, String returnTypeName) {
		Signature signature = createSignature(returnTypeName, argumentName, argumentType);
		methodRow.addSignature(signature);
	}
	
	private Signature createSignature(String returnTypeName, String argumentName, String argumentType) {
		Signature signature = new Signature(returnTypeName);
		signature.addArgument(argumentName, argumentType);
			
		return signature;
	}
	
	private void setUpSuperAndSubModule() {
		ModuleEnvironment superModule = new ModuleEnvironment();
		superModule.setName("SuperModule");
		ModuleEnvironment subModule = new ModuleEnvironment();
		subModule.setName("SubModule");
		subModule.setParentScope(superModule);
		ApplicationMainSymbolTable.addModule(superModule);
		ApplicationMainSymbolTable.addModule(subModule);
	}

}
