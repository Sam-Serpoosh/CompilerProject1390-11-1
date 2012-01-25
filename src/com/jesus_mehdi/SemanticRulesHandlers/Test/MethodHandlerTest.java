package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.CommonTokenStream;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.SymbolTable;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.MethodHandler;

public class MethodHandlerTest {

	@Test
	public void shouldSetMethodName() {
		FileUtility.writeSampleProgramContentToFile("testMethod()");
		MethodHandler methodHandler = new MethodHandler(new StubTokenizer(0));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		methodHandler.setMethodName(commonTokenStream);
		SymbolTableRow memberRow = methodHandler.getMethodRow();
		
		assertEquals("testMethod", memberRow.Name);
	}
	
	@Test
	public void shouldSetMethodReturnType() {
		FileUtility.writeSampleProgramContentToFile("testMethod() : int");
		MethodHandler methodHandler = new MethodHandler(new StubTokenizer(4));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
	
		methodHandler.setReturnType(commonTokenStream);
		SymbolTableRow memberRow = methodHandler.getMethodRow();
		
		assertEquals("int", memberRow.Type);
	}
	
	@Test
	public void shouldCollectMethodArgumentName() {
		FileUtility.writeSampleProgramContentToFile("testMethod(arg : string) : int");
		MethodHandler methodHandler = new MethodHandler(new StubTokenizer(2));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
		
		methodHandler.addArgumentName(commonTokenStream);

		assertEquals("arg", methodHandler.getArgumentName());
	}
	
	@Test
	public void shouldCollectMethodArgumentType() {
		FileUtility.writeSampleProgramContentToFile("testMethod(arg : string) : int");
		MethodHandler methodHandler = new MethodHandler(new StubTokenizer(4));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
		
		methodHandler.setArgumentType(commonTokenStream);

		assertEquals("string", methodHandler.getArgumentType());
	}
	
	@Test
	public void shouldAddMethodToParentModuleSymbolTable() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		methodRow.Type = "bool";
		MethodHandler methodHandler = new MethodHandler();
		methodHandler.setMethodRow(methodRow);
		
		methodHandler.endMethodDeclaration();
		SymbolTable table = moduleEnvironment.getSymbolTable();
		
		assertEquals(1, table.getAllRows().size());
	}
	
}
