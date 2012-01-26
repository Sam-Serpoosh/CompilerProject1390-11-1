package com.jesus_mehdi.DataStructures.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jesus_mehdi.DataStructures.ModuleEnvironment;

public class ModuleEnvironmentTest {

	@Test
	public void shouldBeAbleToDetectWhethereModuleIsSubtypeOfOtherModule() {
		ModuleEnvironment parentModule = new ModuleEnvironment();
		parentModule.setName("ParentModule");
		ModuleEnvironment childModule = new ModuleEnvironment();
		childModule.setName("ModuleName");
		childModule.setParentScope(parentModule);

		assertTrue(childModule.isSubtypeOf(parentModule));
	}

	@Test
	public void shouldBeAbleToDetectWhetherModuleIsSubtypeOfOtherModuleInMoreThanLevel() {
		ModuleEnvironment grandParentModule = new ModuleEnvironment();
		grandParentModule.setName("GrandParentModule");
		ModuleEnvironment parentModule = new ModuleEnvironment();
		parentModule.setName("ParentModule");
		parentModule.setParentScope(grandParentModule);
		ModuleEnvironment childModule = new ModuleEnvironment();
		childModule.setName("ModuleName");
		childModule.setParentScope(parentModule);

		assertTrue(childModule.isSubtypeOf(grandParentModule));
	}

	@Test
	public void shouldNotAssumeGrandParentIsChildParentWhenMiddleModuleIsNotParentOfChild() {
		ModuleEnvironment grandParentModule = new ModuleEnvironment();
		grandParentModule.setName("GrandParentModule");
		ModuleEnvironment parentModule = new ModuleEnvironment();
		parentModule.setName("ParentModule");
		parentModule.setParentScope(grandParentModule);
		ModuleEnvironment childModule = new ModuleEnvironment();
		childModule.setName("ModuleName");

		assertFalse(childModule.isSubtypeOf(grandParentModule));
	}

}
