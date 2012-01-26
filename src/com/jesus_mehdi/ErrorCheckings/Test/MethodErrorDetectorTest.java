package com.jesus_mehdi.ErrorCheckings.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.ErrorCheckings.MethodErrorDetector;

public class MethodErrorDetectorTest {

	@Test
	public void shouldFetchEquivalentVirtualMethodInParentWhenExisted() {
		ModuleEnvironment childModule = setUpParentAndChildMethodsWithSameName(true);
		
		MethodErrorDetector methodErrorDetector = new MethodErrorDetector();
		MethodSymbolTableRow method = methodErrorDetector.getEquivalentVirtualMethodFromParent(
				childModule, "testMethod");
		
		assertNotNull(method);
		assertEquals("testMethod", method.Name);
	}
	
	@Test
	public void whenThereIsNoVirtualMethodInParentsShouldReturnNull() {
		ModuleEnvironment childModule = setUpParentAndChildMethodsWithSameName(false);
		
		MethodErrorDetector methodErrorDetector = new MethodErrorDetector();
		MethodSymbolTableRow method = methodErrorDetector.getEquivalentVirtualMethodFromParent(
				childModule, "testMethod");
		
		assertNull(method);
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
