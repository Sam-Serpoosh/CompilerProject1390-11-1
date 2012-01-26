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
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		Signature signature = new Signature("void");
		signature.addArgument("testArg", "subModule");
		methodRow.addSignature(signature);
		signature = new Signature("void");
		signature.addArgument("testArg", "superModule");
		methodRow.addSignature(signature);
		ModuleEnvironment superModule = new ModuleEnvironment();
		superModule.setName("superModule");
		ModuleEnvironment subModule = new ModuleEnvironment();
		subModule.setName("subModule");
		subModule.setParentScope(superModule);
		ModuleEnvironment mainModule = new ModuleEnvironment();
		mainModule.addRow(methodRow);
		
		ApplicationMainSymbolTable.addModule(subModule);
		ApplicationMainSymbolTable.addModule(superModule);
		
		_methodErrorDetector.checkOverloadingProblemsInAllMethodsSignatures(mainModule);
	}
	
	@Test
	public void shouldNotThrowOverloadingExceptionWhenMethodSignaturesHaveNoRelation() {
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		Signature signature = new Signature("void");
		signature.addArgument("testArg", "subModule");
		methodRow.addSignature(signature);
		signature = new Signature("void");
		signature.addArgument("testArg", "superModule");
		methodRow.addSignature(signature);
		ModuleEnvironment superModule = new ModuleEnvironment();
		superModule.setName("superModule");
		ModuleEnvironment subModule = new ModuleEnvironment();
		subModule.setName("subModule");
		ModuleEnvironment mainModule = new ModuleEnvironment();
		mainModule.addRow(methodRow);
		
		ApplicationMainSymbolTable.addModule(subModule);
		ApplicationMainSymbolTable.addModule(superModule);
		
		_methodErrorDetector.checkOverloadingProblemsInAllMethodsSignatures(mainModule);
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
