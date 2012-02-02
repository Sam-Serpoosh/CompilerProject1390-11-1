package com.jesus_mehdi.Main;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.jesus_mehdi.CompilerFiles.LexerHandlerFirstIteration;
import com.jesus_mehdi.CompilerFiles.LexerHandlerSecondIteration;
import com.jesus_mehdi.CompilerFiles.ParserHandlerFirstIteration;
import com.jesus_mehdi.CompilerFiles.ParserHandlerSecondIteration;
import com.jesus_mehdi.ReportGenerators.ReportFormatter;
import com.jesus_mehdi.SemanticRulesHandlers.ApplicationMainSymbolTable;

public class MainApplication {

	private static final String inputFilePath = 
		"C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\TestSample.txt";
	
	public static void main(String[] args) throws RecognitionException {
		ApplicationMainSymbolTable.init();
		firstIterationParsing();
		secondIterationParsing();
		ReportFormatter reportFormatter = new ReportFormatter();
		reportFormatter.reportToFile();
		System.out.println("Finished!");
	}
	
	private static void firstIterationParsing() throws RecognitionException {
		LexerHandlerFirstIteration scanner = null;
		try {
			ANTLRFileStream inputFileStream = new ANTLRFileStream(inputFilePath);
			scanner = new LexerHandlerFirstIteration(inputFileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		CommonTokenStream commonTokenStream = new CommonTokenStream(scanner);
		ParserHandlerFirstIteration parser = new ParserHandlerFirstIteration(commonTokenStream);
		parser.file();
	}
	
	private static void secondIterationParsing() throws RecognitionException {
		LexerHandlerSecondIteration scanner = null;
		try {
			ANTLRFileStream inputFileStream = new ANTLRFileStream(inputFilePath);
			scanner = new LexerHandlerSecondIteration(inputFileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		CommonTokenStream commonTokenStream = new CommonTokenStream(scanner);
		ParserHandlerSecondIteration parser = new ParserHandlerSecondIteration(commonTokenStream);
		parser.file();
	}

}
