package com.jesus_mehdi.Main;

import java.io.IOException;
import java.util.HashMap;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.jesus_mehdi.CompilerFiles.LexerHandler;
import com.jesus_mehdi.CompilerFiles.ParserHandler;
import com.jesus_mehdi.DataStructures.ModuleEnvironment;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class MainApplication {

	private static final String inputFilePath = 
		"C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\TestSample.txt";
	
	public static void main(String[] args) throws RecognitionException {
		parse();
		HashMap<String, ModuleEnvironment> allModules = ApplicationMainSymbolTable.getAllModules();
		System.out.println("finished!");
	}
	
	private static void parse() throws RecognitionException {
		LexerHandler scanner = null;
		try {
			ANTLRFileStream inputFileStream = new ANTLRFileStream(inputFilePath);
			scanner = new LexerHandler(inputFileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		CommonTokenStream commonTokenStream = new CommonTokenStream(scanner);
		ParserHandler parser = new ParserHandler(commonTokenStream);
		parser.program();
		//System.out.println(parser.file());
	}

}
