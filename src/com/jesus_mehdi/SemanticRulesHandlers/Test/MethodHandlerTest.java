package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.CommonTokenStream;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.DataStructures.SymbolTable;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.Exceptions.MemberAndMethodExistWithSameNameException;
import com.jesus_mehdi.Exceptions.ModuleContainsTwoMainMethodsException;
import com.jesus_mehdi.SemanticRulesHandlers.Current;
import com.jesus_mehdi.SemanticRulesHandlers.MemberHandler;
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
	
	@Test(expected = ModuleContainsTwoMainMethodsException.class)
	public void shouldThrowExceptionWhenTwoMainMethodsInSameModuleDeclared() {
		FileUtility.writeSampleProgramContentToFile("main()\r\nmain()");
		
		declareMethod(0);
		declareMethod(3);
	}
	
	@Test(expected = MemberAndMethodExistWithSameNameException.class)
	public void shouldThrowExceptionWhenMemberAndMethodHaveSameName() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		FileUtility.writeSampleProgramContentToFile("int test\r\ntest()");

		declareMember("test", "int");
		declareMethod(2);
	}
	
	@Test(expected = MemberAndMethodExistWithSameNameException.class)
	public void shouldThrowExceptionWhenMethodAndMemberHaveSameName() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		FileUtility.writeSampleProgramContentToFile("int test\r\ntest()");

		declareMethod(2);
		declareMember("test", "int");
	}
	
	@Test
	public void shouldConcatSignatureOfNewMethodWithSameNameToExistingMethod() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		Signature signature = new Signature();
		signature.addArgument("test", "int");
		MethodHandler methodHandler = new MethodHandler();
		methodHandler.setMethodRow(methodRow);
		methodHandler.endMethodDeclaration();
		
		methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		signature = new Signature();
		signature.addArgument("test", "string");
		methodHandler = new MethodHandler();
		methodHandler.setMethodRow(methodRow);
		methodHandler.endMethodDeclaration();
		
		MethodSymbolTableRow existingMethodRow = (MethodSymbolTableRow)moduleEnvironment.getRow("testMethod");
		
		assertEquals(2, existingMethodRow.getAllSignatures().size());
	}
	
	@Test
	public void shouldHandleMethodWithNoArguments() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		Signature signature = new Signature();
		signature.addArgument("test", "int");
		MethodHandler methodHandler = new MethodHandler();
		methodHandler.setMethodRow(methodRow);
		methodHandler.endMethodDeclaration();
		
		methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		signature = new Signature();
		methodHandler = new MethodHandler();
		methodHandler.setMethodRow(methodRow);
		methodHandler.endMethodDeclaration();
	}
	
	private void declareMethod(int tokenizerIndex) {
		MethodHandler methodHandler = new MethodHandler(new StubTokenizer(tokenizerIndex));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
		methodHandler.setMethodName(commonTokenStream);
		methodHandler.endMethodDeclaration();
	}
	
	private void declareMember(String memberName, String memberType) {
		MemberSymbolTableRow memberRow = new MemberSymbolTableRow();
		memberRow.Name = memberName;
		memberRow.Type = memberType;
		MemberHandler memberHandler = new MemberHandler();
		memberHandler.setMemberRow(memberRow);
		memberHandler.endMemberDeclaration();
	}
	
}
