package com.jesus_mehdi.ErrorCheckings.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.ErrorCheckings.MethodErrorDetector;
import com.jesus_mehdi.Exceptions.MethodWithSameNameIsNotSubMethodOfParentVirtualMethodException;
import com.jesus_mehdi.Exceptions.OverloadingException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class MethodErrorDetectorTest {

	private MethodErrorDetector _methodErrorDetector;
	
	@Before
	public void setUp() {
		_methodErrorDetector = new MethodErrorDetector();
	}
	
	@Test
	public void shouldFetchEquivalentVirtualMethodInParentWhenExisted() {
		ModuleEnvironment childModule = setUpParentAndChildMethodsWithSameName(true);
		MethodSymbolTableRow method = _methodErrorDetector.getEquivalentVirtualMethodFromParent(
				childModule, "testMethod");
		
		assertNotNull(method);
		assertEquals("testMethod", method.Name);
	}
	
	@Test
	public void whenThereIsNoVirtualMethodInParentsShouldReturnNull() {
		ModuleEnvironment childModule = setUpParentAndChildMethodsWithSameName(false);
		MethodSymbolTableRow method = _methodErrorDetector.getEquivalentVirtualMethodFromParent(
				childModule, "testMethod");
		
		assertNull(method);
	}
	
	@Test(expected = OverloadingException.class)
	public void shoudlThrowOverloadingExceptionWhenMethodSignatureHasRelationWithAlreadyExistedSignatures() {
		MethodSymbolTableRow methodRow = createRowWithSignature("testMethod", 
				"void", "testArg", "SubModule");
		MethodSymbolTableRow otherMethodRow = createRowWithSignature("testMethod", 
				"void", "testArg", "SuperModule");
		MethodSymbolTableRow standOutMethodRow = createRowWithSignature("standOutMethod", 
				"void", "testArg", "StandOutModule");
		ModuleEnvironment superModule = createModuleAndAddMethodRowToIt("SuperModule", standOutMethodRow);
		ModuleEnvironment subModule = createModuleAndAddMethodRowToIt("SubModule", standOutMethodRow);
		subModule.setParentScope(superModule);
		ModuleEnvironment mainModule = createModuleAndAddMethodRowToIt("MainModule", methodRow);
		mainModule.addRow(otherMethodRow);
		
		ApplicationMainSymbolTable.addModule(subModule);
		ApplicationMainSymbolTable.addModule(superModule);
		
		_methodErrorDetector.checkOverloadingProblemsInAllMethodsSignatures(mainModule);
	}
	
	@Test
	public void shouldNotThrowOverloadingExceptionWhenMethodSignaturesHaveNoRelation() {
		MethodSymbolTableRow methodRow = createRowWithSignature("testMethod", 
				"void", "testArg", "SubModule");
		MethodSymbolTableRow otherMethodRow = createRowWithSignature("testMethod", 
				"void", "testArg", "SuperModule");
		MethodSymbolTableRow standOutMethodRow = createRowWithSignature("standOutMethod", 
				"void", "testArg", "StandOutModule");
		ModuleEnvironment superModule = createModuleAndAddMethodRowToIt("SuperModule", standOutMethodRow);
		ModuleEnvironment subModule = createModuleAndAddMethodRowToIt("SubModule", standOutMethodRow);
		ModuleEnvironment mainModule = createModuleAndAddMethodRowToIt("MainModule", methodRow);
		mainModule.addRow(otherMethodRow);
		
		ApplicationMainSymbolTable.addModule(subModule);
		ApplicationMainSymbolTable.addModule(superModule);
		
		_methodErrorDetector.checkOverloadingProblemsInAllMethodsSignatures(mainModule);
	}
	
	@Test
	public void shouldNotThrowExceptionWhenChildMethodWithSameNameIsNotSubMethodOfParentVirtualMethod() {
		MethodSymbolTableRow parentMethodRow = createVirtualRowWithSignature("testVirtualName", 
				"SuperModule", "tesArg", "SubModule");
		MethodSymbolTableRow childMethodRow = createRowWithSignature("testVirtualMethod", 
				"SubModule", "testArg", "SuperModule");
		ModuleEnvironment superModule = createModuleAndAddMethodRowToIt("SuperModule", parentMethodRow);
		ModuleEnvironment subModule = createModuleAndAddMethodRowToIt("SubModule", childMethodRow);
		subModule.setParentScope(superModule);
		
		ApplicationMainSymbolTable.addModule(superModule);
		ApplicationMainSymbolTable.addModule(subModule);
		
		_methodErrorDetector.checkExistanceOfVirtualMethodWithSameName(subModule, childMethodRow);
	}
	
	@Test(expected = MethodWithSameNameIsNotSubMethodOfParentVirtualMethodException.class)
	public void shouldThrowExceptionWhenChildMethodWithSameNameIsNotSubMethodOfParentVirtualMethod() {
		MethodSymbolTableRow parentMethodRow = createVirtualRowWithSignature("testVirtualMethod", 
				"StandOutModule", "testArg", "SubModule");
		MethodSymbolTableRow childMethodRow = createRowWithSignature("testVirtualMethod", 
				"SubModule", "testArg", "SuperModule");
		ModuleEnvironment superModule = createModuleAndAddMethodRowToIt("SuperModule", parentMethodRow);
		ModuleEnvironment subModule = createModuleAndAddMethodRowToIt("SubModule", childMethodRow);
		subModule.setParentScope(superModule);
		ModuleEnvironment standOutModule = new ModuleEnvironment();
		standOutModule.setName("StandOutModule");
		
		ApplicationMainSymbolTable.addModule(superModule);
		ApplicationMainSymbolTable.addModule(subModule);
		ApplicationMainSymbolTable.addModule(standOutModule);
		
		_methodErrorDetector.checkExistanceOfVirtualMethodWithSameName(subModule, childMethodRow);
	} 
	
	private MethodSymbolTableRow createRowWithSignature(String methodName, String returnType, 
			String argumentName, String argumentType) {
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = methodName;
		Signature signature = new Signature(returnType);
		signature.addArgument(argumentName, argumentType);
		methodRow.addSignature(signature);
		
		return methodRow;
	}
	
	private MethodSymbolTableRow createVirtualRowWithSignature(String methodName, String returnType, 
			String argumentName, String argumentType) {
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = methodName;
		Signature signature = new Signature(returnType);
		signature.addArgument(argumentName, argumentType);
		methodRow.addSignature(signature);
		methodRow.setVirtual();
		
		return methodRow;
	}
	
	private ModuleEnvironment createModuleAndAddMethodRowToIt(String moduleName, 
			MethodSymbolTableRow methodRow) {
		ModuleEnvironment module = new ModuleEnvironment();
		module.setName(moduleName);
		module.addRow(methodRow);
		
		return module;
	}
	
	private ModuleEnvironment setUpParentAndChildMethodsWithSameName(boolean parentMethodShouldBeVirtual) {
		ModuleEnvironment parentModule = new ModuleEnvironment();
		parentModule.setName("ParentModule");
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		if (parentMethodShouldBeVirtual)
			methodRow.setVirtual();
		parentModule.addRow(methodRow);
		
		ModuleEnvironment childModule = new ModuleEnvironment();
		childModule.setName("ChildModule");
		childModule.setParentScope(parentModule);
		
		return childModule;
	}
	
}
