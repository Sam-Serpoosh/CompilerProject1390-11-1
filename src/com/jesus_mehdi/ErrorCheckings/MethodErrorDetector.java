package com.jesus_mehdi.ErrorCheckings;

import java.util.ArrayList;

import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.Exceptions.MethodWithSameNameIsNotSubMethodOfParentVirtualMethodException;
import com.jesus_mehdi.Exceptions.OverloadingException;

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
	
	public void checkOverloadingProblemsInAllMethodsSignatures(ModuleEnvironment module) {
		ArrayList<MethodSymbolTableRow> allModuleMethods = module.getSymbolTable().getAllMethodRows();
		for (MethodSymbolTableRow method : allModuleMethods) {
			ArrayList<Signature> allMethodSignatures = method.getAllSignatures();
			checkForOverloadingProblmInMethodSignatures(allMethodSignatures);
		}
		
	}

	private void checkForOverloadingProblmInMethodSignatures(ArrayList<Signature> allMethodSignatures) {
		for (int i = 0; i < allMethodSignatures.size(); i++) {
			for (int j = 0; j < i; j++) {
				Signature currentSignature = allMethodSignatures.get(i);
				Signature previousSignature = allMethodSignatures.get(j);
				
				if (currentSignature.isSubSignatureOf(previousSignature) || 
						previousSignature.isSubSignatureOf(currentSignature))
					throw new OverloadingException();
			}
		}
	}
	
	public void checkExistanceOfVirtualMethodWithSameName(ModuleEnvironment childModule, 
			MethodSymbolTableRow childMethodRow) {
		MethodSymbolTableRow virtualMethod = getEquivalentVirtualMethodFromParent(childModule, childMethodRow.Name);
		if (virtualMethod != null) {
			Signature virtualMethodSignature = virtualMethod.getFirstSignature();
			ArrayList<Signature> methodSignatures = childMethodRow.getAllSignatures();
			for (Signature signature : methodSignatures)
				if (signature.isSubMethod(virtualMethodSignature) == false)
					throw new MethodWithSameNameIsNotSubMethodOfParentVirtualMethodException();
		}
	}
	
}
