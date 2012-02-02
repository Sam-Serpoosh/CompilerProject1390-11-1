package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.antlr.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.Exceptions.DuplicateModuleDeclarationException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.ModuleHandler;

public class ModuleHandlerTest {

	@Test
	public void startModuleShouldNotAddModuleToMainSymbolTable() {
		FileUtility.writeSampleProgramContentToFile("module SampleModule {}");
		ModuleHandler moduleHandler = new ModuleHandler();
		moduleHandler.startModule();
		HashMap<String, ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules();

		assertEquals(0, allModules.size());
	}

	@Test
	public void shouldBeAbleToSetTheNameOfModuleEnvironment() {
		FileUtility.writeSampleProgramContentToFile("module SampleModule {}");
		ModuleHandler moduleHandler = new ModuleHandler(new StubTokenizer(1));
		moduleHandler.startModule();
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		moduleHandler.setModuleName(commonTokenStream);
		HashMap<String, ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules();
		
		assertNotNull(allModules.get("SampleModule"));
		assertEquals(1, allModules.size()); 
	}
	
	@Test
	public void shouldBeAbleToSetParentModuleName() {
		FileUtility.writeSampleProgramContentToFile("module SampleModule childof ParentModule {}");
		ModuleHandler moduleHandler = new ModuleHandler(new StubTokenizer(3));
		moduleHandler.startModule();
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		moduleHandler.setParentModuleName(commonTokenStream);
		ModuleEnvironment moduleEnvironment = moduleHandler.getModuleEnvironment();
		
		assertEquals("ParentModule", moduleEnvironment.getParentName());
	}
	
	@Test
	public void shouldHandleMultipleModuleDeclaration() {
		FileUtility.writeSampleProgramContentToFile("module FirstModule {}\r\nmodule SecondModule {}");

		checkModuleDeclaration("FirstModule", 1);
		checkModuleDeclaration("SecondModule", 5);
		
		HashMap<String, ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules();
		assertEquals(2, allModules.size());
	}
	
	@Test(expected = DuplicateModuleDeclarationException.class)
	public void shouldThrowDuplicateModuleDeclarationExceptionWhenTwoModulesDeclaredWithSameName() {
		FileUtility.writeSampleProgramContentToFile("module SampleModule {}\r\nmodule SampleModule {}");
		
		handleModuleDeclaration(1);
		handleModuleDeclaration(5);
	}

	private void handleModuleDeclaration(int tokenizerIndex) {
		ModuleHandler moduleHandler = new ModuleHandler(new StubTokenizer(tokenizerIndex));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
		moduleHandler.startModule();
		moduleHandler.setModuleName(commonTokenStream);
	}
	
	private void checkModuleDeclaration(String expectedModuleName, int tokenizerIndex) {
		ModuleHandler moduleHandler = new ModuleHandler(new StubTokenizer(tokenizerIndex));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
		
		moduleHandler.startModule();
		moduleHandler.setModuleName(commonTokenStream);
		HashMap<String, ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules();
		
		assertNotNull(allModules.get(expectedModuleName));
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}

}
