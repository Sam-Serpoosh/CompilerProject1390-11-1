package com.jesus_mehdi.SemanticRulesHandlers;

import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

public class Tokenizer {

	public final int LAST_TOKEN = -1;
	
	public String getSpecificToken(CommonTokenStream inputToken, int tokenIndex) {
		List<Token> allTokens = ((CommonTokenStream)inputToken).getTokens();
		int index = ((CommonTokenStream)inputToken).index();
		String tokenText = allTokens.get(index + tokenIndex).getText();
		
		return tokenText;
	}
	
}
