package com.jesus_mehdi.Main;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.jesus_mehdi.CompilerFiles.LexerHandler;
import com.jesus_mehdi.CompilerFiles.ParserHandler;

public class MainApplication {

	private static final String inputFilePath = "C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\sample.txt";
	
	public static void main(String[] args) throws RecognitionException {
		parse();
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
		System.out.println(parser.file());
	}

}
