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
	private final String END_LINE = "\r\n";
	private final String TAB = "\t";
	
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
				_reportBuilder.append(END_LINE);
			}
	}
	
	public void shapeModuleReport(ModuleEnvironment module) {
		ArrayList<MemberSymbolTableRow> memberRows = module.getSymbolTable().getAllMemberRows();
		ArrayList<MethodSymbolTableRow> methodRows = module.getSymbolTable().getAllMethodRows();
		
		appendAttribute("module name", module.getName(), 0);
		if (module.getParentScope() != null)
			appendAttribute("parnt name", module.getParentName(), 1);
		appendAttribute("num of attributes", memberRows.size(), 1);
		for (MemberSymbolTableRow memberRow : memberRows)
			reportVariable(memberRow, 2);
		_reportBuilder.append(END_LINE);
		
		appendAttribute("num of methods", methodRows.size(), 1);
		shapeAllModuleMethodsReport(methodRows);
	}
	
	public void shapeAllModuleMethodsReport(ArrayList<MethodSymbolTableRow> moduleMethodRows) {
		for (MethodSymbolTableRow methodRow : moduleMethodRows)
			for (Signature signature : methodRow.getAllSignatures())
				shapeMethodReport(signature, methodRow.isVirtual());
	}
	
	public void shapeMethodReport(Signature signature, boolean isVirtual) {
		MethodEnvironment methodEnvironment = signature.getMethodEnvironment();
		appendAttribute("name", methodEnvironment.getName(), 2);
		appendAttribute("is_virtual", isVirtual, 2);
		appendAttribute("return type", methodEnvironment.getReturnTypeName(), 2);
		appendAttribute("num of arguments", signature.getArgumentsCount(), 2);
		shapeArgumentReport(signature);
		appendAttribute("num of local vars", signature.getLocalVariablesCount(), 2);
		shapeLocalVariablesReport(signature);
		_reportBuilder.append(END_LINE);
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
		appendAttribute("name", variableRow.Name, tabCount);
		appendAttribute("type", variableRow.Type, tabCount);
		appendAttribute("address", variableRow.Offset, tabCount);
		if (variableRow.isArray())
			appendAttribute("sizes", variableRow.ArraySize, tabCount);
		_reportBuilder.append(END_LINE);
	}

	private boolean isArgument(String variableName, Signature signature) {
		for (SimpleEntry<String, String> argument : signature.getAllArguments())
			if (variableName.equals(argument.getKey()))
				return true;
		
		return false;
	}

	private void appendAttribute(String name, Object value, int tabCount) {
		String tab = "";
		for (int i = 0; i < tabCount; i++)
			tab += TAB;
		
		_reportBuilder.append(tab + name + " : " + value.toString() + END_LINE);
	}
	
}
