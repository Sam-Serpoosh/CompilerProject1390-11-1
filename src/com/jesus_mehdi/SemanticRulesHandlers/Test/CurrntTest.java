package com.jesus_mehdi.SemanticRulesHandlers.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;
import com.jesus_mehdi.SemanticRulesHandlers.Current;

public class CurrntTest {

	@Test
	public void shouldBeAbleToSetCurrentScopeByModuleName() {
		ModuleEnvironment module = new ModuleEnvironment();
		module.setName("CurrentModule");
		ApplicationMainSymbolTable.addModule(module);
		
		assertNull(Current.getScope());
		Current.setCurrentScopeByModuleName("CurrentModule");
		
		assertEquals("CurrentModule", ((ModuleEnvironment)Current.getScope()).getName());
		ApplicationMainSymbolTable.clearMainSymbolTable();
	}
	
}
