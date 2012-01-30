package com.jesus_mehdi.ReportGenerators;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;

import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.MethodEnvironment;
import com.jesus_mehdi.DataStructures.MethodSymbolTableRow;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.DataStructures.Signature;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class ReportFormatter {

	private StringBuilder _reportBuilder;
	private final String REPORT_FILE_NAME = 
		"C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\Report.txt";
	
	public ReportFormatter() {
		_reportBuilder = new StringBuilder();
	}
	
	public void reportToFile() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(REPORT_FILE_NAME);
			writer.println(shapeReport());
			writer.close();
		} catch (FileNotFoundException e) { }
	}
	
	public String shapeReport() {
		shapeAllModulesReports();
		return _reportBuilder.toString();
	}
	
	public void shapeAllModulesReports() {
		for (ModuleEnvironment module : ApplicationMainSymbolTable.getAllModules().values())
			if (module.isBaseTypeForReport() == false) {
				shapeModuleReport(module);
				_reportBuilder.append("\r\n");
			}
	}
	
	public void shapeModuleReport(ModuleEnvironment module) {
		ArrayList<MemberSymbolTableRow> memberRows = module.getSymbolTable().getAllMemberRows();
		ArrayList<MethodSymbolTableRow> methodRows = module.getSymbolTable().getAllMethodRows();
		
		createAttribute("module name", module.getName(), 0);
		if (module.getParentScope() != null)
			createAttribute("parnt name", module.getParentName(), 1);
		createAttribute("num of attributes", memberRows.size(), 1);
		for (MemberSymbolTableRow memberRow : memberRows)
			reportVariable(memberRow, 2);
		_reportBuilder.append("\r\n");
		
		createAttribute("num of methods", methodRows.size(), 1);
		shapeAllModuleMethodsReport(methodRows);
	}
	
	public void shapeAllModuleMethodsReport(ArrayList<MethodSymbolTableRow> moduleMethodRows) {
		for (MethodSymbolTableRow methodRow : moduleMethodRows)
			for (Signature signature : methodRow.getAllSignatures())
				shapeMethodReport(signature, methodRow.isVirtual());
	}
	
	public void shapeMethodReport(Signature signature, boolean isVirtual) {
		MethodEnvironment methodEnvironment = signature.getMethodEnvironment();
		createAttribute("name", methodEnvironment.getName(), 2);
		createAttribute("is_virtual", isVirtual, 2);
		createAttribute("return type", methodEnvironment.getReturnTypeName(), 2);
		createAttribute("num of arguments", signature.getArgumentsCount(), 2);
		shapeArgumentReport(signature);
		createAttribute("num of local vars", signature.getLocalVariablesCount(), 2);
		shapeLocalVariablesReport(signature);
		_reportBuilder.append("\r\n");
	}
	
	private void shapeLocalVariablesReport(Signature signature) {
		MethodEnvironment methodEnvironment = signature.getMethodEnvironment();
		for (MemberSymbolTableRow variableRow : methodEnvironment.getAllMemberRows())
			if (isArgument(variableRow.Name, signature) == false)
				reportVariable(variableRow, 3);
	}

	private void shapeArgumentReport(Signature signature) {
		MethodEnvironment methodEnvironment = signature.getMethodEnvironment();
		for (SimpleEntry<String, String> argument : signature.getAllArguments())
			reportVariable(methodEnvironment.getMemberRowByName(argument.getKey()), 3);
	}
	
	private void reportVariable(MemberSymbolTableRow variableRow, int tabCount) {
		createAttribute("name", variableRow.Name, tabCount);
		createAttribute("type", variableRow.Type, tabCount);
		createAttribute("address", variableRow.Offset, tabCount);
		if (variableRow.isArray())
			createAttribute("sizes", variableRow.ArraySize, tabCount);
		_reportBuilder.append("\r\n");
	}

	private boolean isArgument(String variableName, Signature signature) {
		for (SimpleEntry<String, String> argument : signature.getAllArguments())
			if (variableName.equals(argument.getKey()))
				return true;
		
		return false;
	}

	private void createAttribute(String name, Object value, int tabCount) {
		String tab = "";
		for (int i = 0; i < tabCount; i++)
			tab += "\t";
		
		_reportBuilder.append(tab + name + " : " + value.toString() + "\r\n");
	}
	
}
