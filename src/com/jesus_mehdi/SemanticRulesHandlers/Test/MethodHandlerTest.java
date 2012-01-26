package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

import org.antlr.runtime.CommonTokenStream;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.DataStructures.SymbolTable;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.Exceptions.MemberAndMethodExistWithSameNameException;
import com.jesus_mehdi.Exceptions.MethodsDeclaredWithSameNameWhichAtLeastOneOfThemIsVirtualException;
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
		ModuleEnvironment currentModule = new ModuleEnvironment();
		Current.setCurrentScope(currentModule);
		FileUtility.writeSampleProgramContentToFile("testMethod() : int");
		MethodHandler methodHandler = new MethodHandler(new StubTokenizer(4));
		CommonTokenStream commonTokenStream = FileUtility.getCommonTokenStream();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		currentModule.addRow(methodRow);
		methodHandler.setMethodRow(methodRow);
		methodHandler.setReturnType(commonTokenStream);
		methodHandler.endMethodDeclaration();
		
		assertEquals("int", methodRow.getFirstSignature().getReturnType());
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
		declareMethodWithSignature("testMethod", new SimpleEntry<String, String>("test", "int"));
		declareMethodWithSignature("testMethod", new SimpleEntry<String, String>("test", "string"));

		MethodSymbolTableRow existingMethodRow = (MethodSymbolTableRow)moduleEnvironment.getRow("testMethod");
		ArrayList<Signature> allSignatures = existingMethodRow.getAllSignatures();
		assertEquals(2, allSignatures.size());
		assertTrue(allSignatures.get(0).containsArgument("test", "int"));
		assertTrue(allSignatures.get(1).containsArgument("test", "string"));
	}
	
	@Test
	public void shouldHandleMethodWithNoArguments() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		
		declareMethodWithSignature("testMethod", new SimpleEntry<String, String>("test", "int"));
		declareMethodWithSignature("testMethod", new SimpleEntry<String, String>(null, null));
		
		MethodSymbolTableRow existingMethodRow = (MethodSymbolTableRow)moduleEnvironment.getRow("testMethod");
		ArrayList<Signature> allSignatures = existingMethodRow.getAllSignatures();
		assertEquals(2, allSignatures.size());
		assertTrue(allSignatures.get(0).containsArgument("test", "int"));
		assertEquals(0, allSignatures.get(1).getArgumentsCount());
	}
	
	@Test
	public void shouldHandleMethodsWithSameNamesAndDifferentNumberOfArguments() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		Current.setCurrentScope(moduleEnvironment);
		
		declareMethodWithSignature("testMethod", new SimpleEntry<String, String>("first", "int"), 
				new SimpleEntry<String, String>("second", "string"));
		declareMethodWithSignature("testMethod", new SimpleEntry<String, String>("first", "int"));
		
		MethodSymbolTableRow existingMethodRow = (MethodSymbolTableRow)moduleEnvironment.getRow("testMethod");
		ArrayList<Signature> allSignatures = existingMethodRow.getAllSignatures();
		
		assertEquals(2, allSignatures.size());
		assertTrue(allSignatures.get(0).containsArgument("first", "int"));
		assertTrue(allSignatures.get(0).containsArgument("second", "string"));
		assertEquals(2, allSignatures.get(0).getArgumentsCount());
		
		assertTrue(allSignatures.get(1).containsArgument("first", "int"));
		assertEquals(1, allSignatures.get(1).getArgumentsCount());
		
	}
	
	@Test(expected = MethodsDeclaredWithSameNameWhichAtLeastOneOfThemIsVirtualException.class)
	public void shouldThrowExceptionWhenMethodsExistWithSameNameWhichAtLeastOneOfThemIsVirtual() {
		MethodHandler methodHandler = new MethodHandler();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "testMethod";
		methodRow.setVirtual();
		methodHandler.setMethodRow(methodRow);
		methodHandler.endMethodDeclaration();
		MethodSymbolTableRow newMethodRow = new MethodSymbolTableRow();
		newMethodRow.Name = "testMethod";
		methodHandler.setMethodRow(newMethodRow);
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
	
	private void declareMethodWithSignature(String methodName, SimpleEntry<String, String>... arguments) {
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = methodName;
		Signature signature = new Signature();
		for (SimpleEntry<String, String> argument : arguments)
			if (argument.getKey() != null && argument.getValue() != null)
				signature.addArgument(argument.getKey(), argument.getValue());
		MethodHandler methodHandler = new MethodHandler();
		methodHandler.setArguments(signature);
		methodHandler.setMethodRow(methodRow);
		methodHandler.endMethodDeclaration();
	}
	
}
