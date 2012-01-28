package com.jesus_mehdi.ErrorCheckings.Test;

import org.junit.After;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.ErrorCheckings.ModuleErrorDetector;
import com.jesus_mehdi.Exceptions.LoopInheritanceException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class ModuleErrorDetectorTest {

	@Test(expected = LoopInheritanceException.class)
	public void shouldThrowLoopInheritanceExceptionWhenThereModuleHasCyclicInheritance() {
		ModuleEnvironment firstModule = new ModuleEnvironment();
		firstModule.setName("FirstModule");
		ModuleEnvironment secondModule = new ModuleEnvironment();
		secondModule.setName("SecondModule");
		firstModule.setParentScope(secondModule);
		secondModule.setParentScope(firstModule);
		
		ApplicationMainSymbolTable.addModule(firstModule);
		ApplicationMainSymbolTable.addModule(secondModule);
		
		ModuleErrorDetector moduleErrorDetector = new ModuleErrorDetector();
		moduleErrorDetector.checkForLoopInInheritance();
	}
	
	@Test(expected = LoopInheritanceException.class)
	public void shouldThrowExceptionWhenThreeLevelLoopInheritanceExisted() {
		ModuleEnvironment firstModule = new ModuleEnvironment();
		firstModule.setName("FirstModule");
		ModuleEnvironment secondModule = new ModuleEnvironment();
		secondModule.setName("SecondModule");
		ModuleEnvironment thirdModule = new ModuleEnvironment();
		thirdModule.setName("ThirdModule");
		firstModule.setParentScope(secondModule);
		secondModule.setParentScope(thirdModule);
		thirdModule.setParentScope(firstModule);
		
		ApplicationMainSymbolTable.addModule(firstModule);
		ApplicationMainSymbolTable.addModule(secondModule);
		ApplicationMainSymbolTable.addModule(thirdModule);
		
		ModuleErrorDetector moduleErrorDetector = new ModuleErrorDetector();
		moduleErrorDetector.checkForLoopInInheritance();
	}
	
	@Test(expected = LoopInheritanceException.class)
	public void shouldThrowExceptionWhenModuleInheritFromItself() {
		ModuleEnvironment firstModule = new ModuleEnvironment();
		firstModule.setName("FirstModule");
		firstModule.setParentScope(firstModule);
		
		ApplicationMainSymbolTable.addModule(firstModule);
		
		ModuleErrorDetector moduleErrorDetector = new ModuleErrorDetector();
		moduleErrorDetector.checkForLoopInInheritance();
	}
	
	@Test
	public void whenThereIsNoLoopInInheritanceShouldNotThrowException() {
		ModuleEnvironment firstModule = new ModuleEnvironment();
		firstModule.setName("FirstModule");
		ModuleEnvironment secondModule = new ModuleEnvironment();
		secondModule.setName("SecondModule");
		ModuleEnvironment thirdModule = new ModuleEnvironment();
		thirdModule.setName("ThirdModule");
		firstModule.setParentScope(secondModule);
		secondModule.setParentScope(thirdModule);
		
		ApplicationMainSymbolTable.addModule(firstModule);
		ApplicationMainSymbolTable.addModule(secondModule);
		ApplicationMainSymbolTable.addModule(thirdModule);
		
		ModuleErrorDetector moduleErrorDetector = new ModuleErrorDetector();
		moduleErrorDetector.checkForLoopInInheritance();
	}
	
	@After
	public void clearMainSymbolTable() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
