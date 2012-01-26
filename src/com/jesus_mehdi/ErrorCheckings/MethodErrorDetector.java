package com.jesus_mehdi.ErrorCheckings;

import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;

public class MethodErrorDetector {

	public MethodSymbolTableRow getEquivalentVirtualMethodFromParent(ModuleEnvironment module, String methodName) {
		ModuleEnvironment parentModule = (ModuleEnvironment)module.getParentScope();
		while (parentModule != null) {
			if (parentModule.rowAlreadyExisted(methodName)) {
				MethodSymbolTableRow methodRow = (MethodSymbolTableRow)parentModule.getRow(methodName);
				if (methodRow.isVirtual())
					return methodRow;
			}
			parentModule = (ModuleEnvironment)parentModule.getParentScope();
		}
		return null;
	}
	
}
