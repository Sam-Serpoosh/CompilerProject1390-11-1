package com.jesus_mehdi.SemanticRulesHandlers.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;

import com.jesus_mehdi.CompilerFiles.LexerHandlerFirstIteration;

public class FileUtility {

	private final static String _sampleFileName = "Sample.txt"; 
	
	public static void writeSampleProgramContentToFile(String programContent) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(_sampleFileName);
			writer.println(programContent);
			writer.close();
		} catch (FileNotFoundException e) { }
	}

	public static CommonTokenStream getCommonTokenStream() {
		LexerHandlerFirstIteration scanner = null;
		try {
			ANTLRFileStream inputFileStream = new ANTLRFileStream(_sampleFileName);
			scanner = new LexerHandlerFirstIteration(inputFileStream);
		} catch (IOException e) { }

		return new CommonTokenStream(scanner);
	}
	
}
