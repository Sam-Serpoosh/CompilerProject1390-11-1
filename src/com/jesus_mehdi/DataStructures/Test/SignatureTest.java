package com.jesus_mehdi.DataStructures.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class SignatureTest {

	@Test
	public void shouldDetectWhetherSignatureIsSubtypeOfOtherSignature() {
		Signature subSignature = new Signature("void");
		subSignature.addArgument("firstSubArg", "SubModule");
		subSignature.addArgument("secondSubArg", "SubModule");
		Signature superSignature = new Signature("void");
		superSignature.addArgument("firstSuperArg", "SuperModule");
		superSignature.addArgument("secondSuperArg", "SuperModule");
		ModuleEnvironment superModule = new ModuleEnvironment();
		superModule.setName("SuperModule");
		ModuleEnvironment subModule = new ModuleEnvironment();
		subModule.setName("SubModule");
		subModule.setParentScope(superModule);
		
		ApplicationMainSymbolTable.addModule(superModule);
		ApplicationMainSymbolTable.addModule(subModule);
		
		assertTrue(subSignature.isSubSignatureOf(superSignature));
	}
	
	@Test
	public void whenSignatureIsNotSubSignatureShouldReturnFalse() {
		Signature subSignature = new Signature("void");
		subSignature.addArgument("firstArg", "firstModule");
		subSignature.addArgument("secondArg", "firstModule");
		Signature superSignature = new Signature("void");
		superSignature.addArgument("firstArg", "secondModule");
		superSignature.addArgument("secondArg", "secondModule");
		ModuleEnvironment superModule = new ModuleEnvironment();
		superModule.setName("firstModule");
		ModuleEnvironment subModule = new ModuleEnvironment();
		subModule.setName("secondModule");
		
		ApplicationMainSymbolTable.addModule(superModule);
		ApplicationMainSymbolTable.addModule(subModule);
		
		assertFalse(subSignature.isSubSignatureOf(superSignature));
	}
	
	@Test
	public void whenNumberOfArgumentsAreDifferentShouldNotBeSubSignature() {
		Signature subSignature = new Signature("void");
		subSignature.addArgument("firstSubArg", "SubModule");
		Signature superSignature = new Signature("void");
		superSignature.addArgument("firstSuperArg", "SuperModule");
		superSignature.addArgument("secondSuperArg", "SuperModule");
		ModuleEnvironment superModule = new ModuleEnvironment();
		superModule.setName("SuperModule");
		ModuleEnvironment subModule = new ModuleEnvironment();
		subModule.setName("SubModule");
		subModule.setParentScope(superModule);
		
		ApplicationMainSymbolTable.addModule(superModule);
		ApplicationMainSymbolTable.addModule(subModule);
		
		assertFalse(subSignature.isSubSignatureOf(superSignature));
	}
	
	@Test
	public void shouldDetectWhetherMethodIsSubMethodOfOtherMethod() {
		Signature subSignature = new Signature("SubModule");
		subSignature.addArgument("superArg", "SuperModule");
		Signature superSignature = new Signature("SuperModule");
		superSignature.addArgument("subArg", "SubModule");
		ModuleEnvironment superModule = new ModuleEnvironment();
		superModule.setName("SuperModule");
		ModuleEnvironment subModule = new ModuleEnvironment();
		subModule.setName("SubModule");
		subModule.setParentScope(superModule);
		ApplicationMainSymbolTable.addModule(superModule);
		ApplicationMainSymbolTable.addModule(subModule);
		
		assertTrue(subSignature.isSubMethod(superSignature));
		assertTrue(subSignature.isSubMethod(subSignature));
		assertFalse(superSignature.isSubMethod(subSignature));
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
