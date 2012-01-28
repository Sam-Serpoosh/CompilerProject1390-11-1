package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.SymbolTable;
import com.jesus_mehdi.Exceptions.BaseModuleNotExistedException;
import com.jesus_mehdi.Exceptions.MultipleMainMethodsException;
import com.jesus_mehdi.Exceptions.NoMainMethodException;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class ApplicationMainSymbolTableTest {

	@Test(expected = NoMainMethodException.class)
	public void shoudlThrowExceptionWhenThereIsNoMainMethodsInApplication() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		SymbolTable symbolTable = new SymbolTable();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "NotMain";
		symbolTable.addRow(methodRow);
		moduleEnvironment.setSymbolTable(symbolTable);
		ApplicationMainSymbolTable.addModule(moduleEnvironment);
		
		ApplicationMainSymbolTable.setApplicationEntryPoint();
	}
	
	@Test(expected = MultipleMainMethodsException.class)
	public void shouldThrowExceptionWhenThereAreMultipleMainMethods() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		moduleEnvironment.setName("Module");
		SymbolTable symbolTable = new SymbolTable();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "Main";
		symbolTable.addRow(methodRow);
		moduleEnvironment.setSymbolTable(symbolTable);
		moduleEnvironment.setContainsMainMethod();
		ApplicationMainSymbolTable.addModule(moduleEnvironment);
		
		ModuleEnvironment otherModuleEnvironment = new ModuleEnvironment();
		otherModuleEnvironment.setName("OtherModule");
		SymbolTable otherSymbolTable = new SymbolTable();
		methodRow = new MethodSymbolTableRow();
		methodRow.Name = "main";
		otherSymbolTable.addRow(methodRow);
		otherModuleEnvironment.setSymbolTable(otherSymbolTable);
		otherModuleEnvironment.setContainsMainMethod();
		ApplicationMainSymbolTable.addModule(otherModuleEnvironment);
		
		ApplicationMainSymbolTable.setApplicationEntryPoint();
	}
	
	@Test
	public void shouldSetApplicationEntryModuleAccordingToMainMethodInIt() {
		ModuleEnvironment moduleEnvironment = new ModuleEnvironment();
		moduleEnvironment.setName("Module");
		SymbolTable symbolTable = new SymbolTable();
		MethodSymbolTableRow methodRow = new MethodSymbolTableRow();
		methodRow.Name = "SimpleMain";
		symbolTable.addRow(methodRow);
		moduleEnvironment.setSymbolTable(symbolTable);
		ApplicationMainSymbolTable.addModule(moduleEnvironment);
		
		ModuleEnvironment otherModuleEnvironment = new ModuleEnvironment();
		otherModuleEnvironment.setName("OtherModule");
		SymbolTable otherSymbolTable = new SymbolTable();
		methodRow = new MethodSymbolTableRow();
		methodRow.Name = "main";
		otherSymbolTable.addRow(methodRow);
		otherModuleEnvironment.setSymbolTable(otherSymbolTable);
		otherModuleEnvironment.setContainsMainMethod();
		ApplicationMainSymbolTable.addModule(otherModuleEnvironment);
		
		ApplicationMainSymbolTable.setApplicationEntryPoint();
		
		assertEquals(otherModuleEnvironment, ApplicationMainSymbolTable.getApplicationEntryModule());
	}
	
	@Test(expected = BaseModuleNotExistedException.class)
	public void shouldThrowExceptionWhenModuleInheritedFromNotExistedModule() {
		ModuleEnvironment childModule = new ModuleEnvironment();
		childModule.setName("ChildModule");
		childModule.setParentName("ParentModule");
		ApplicationMainSymbolTable.addModule(childModule);
		
		ApplicationMainSymbolTable.checkThatAllParentModulesExist();
	}
	
	@After
	public void tearDown() {
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
