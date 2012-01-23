package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jesus_mehdi.CompilerFiles.LexerHandler;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.ModuleHandler;

public class ModuleHandlerTest {

	private String _sampleFileName;
	private ModuleHandler _moduleHandler;

	@Before
	public void setUp() {
		_sampleFileName = "Sample.txt";
		_moduleHandler = new ModuleHandler();
	}

	@Test
	public void startModuleShouldNotAddModuleToMainSymbolTable() {
		writeSampleProgramContentToFile("module SampleModule {}");
		_moduleHandler.startModule();
		HashMap<String, ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules();

		assertEquals(0, allModules.size());
	}

	@Test
	public void shouldBeAbleToSetTheNameOfModuleEnvironment() {
		writeSampleProgramContentToFile("module SampleModule {}");
		ModuleHandler moduleHandler = new StubModuleHandler(1);
		moduleHandler.startModule();
		CommonTokenStream commonTokenStream = getCommonTokenStream();
	
		moduleHandler.setModuleName(commonTokenStream);
		HashMap<String, ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules();
		
		assertNotNull(allModules.get("SampleModule"));
		assertEquals(1, allModules.size()); 
	}
	
	@Test
	public void shouldBeAbleToSetParentModuleName() {
		writeSampleProgramContentToFile("module SampleModule childof ParentModule {}");
		ModuleHandler moduleHandler = new StubModuleHandler(3);
		moduleHandler.startModule();
		CommonTokenStream commonTokenStream = getCommonTokenStream();
	
		moduleHandler.setParentModuleName(commonTokenStream);
		ModuleEnvironment moduleEnvironment = moduleHandler.getModuleEnvironment();
		
		assertEquals("ParentModule", moduleEnvironment.getParentName());
	}

	private void writeSampleProgramContentToFile(String programContent) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(_sampleFileName);
			writer.println(programContent);
			writer.close();
		} catch (FileNotFoundException e) { }
	}

	private CommonTokenStream getCommonTokenStream() {
		LexerHandler scanner = null;
		try {
			ANTLRFileStream inputFileStream = new ANTLRFileStream(
					_sampleFileName);
			scanner = new LexerHandler(inputFileStream);
		} catch (IOException e) { }

		return new CommonTokenStream(scanner);
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.getAllModules().clear();
	}

}
