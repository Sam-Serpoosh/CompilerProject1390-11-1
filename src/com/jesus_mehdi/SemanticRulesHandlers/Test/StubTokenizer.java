package com.jesus_mehdi.SemanticRulesHandlers.Test;

import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;

import com.jesus_mehdi.SemanticRulesHandlers.Tokenizer;

public class StubTokenizer extends Tokenizer {

	private int _tokenIndex;
	
	public StubTokenizer(int tokenIndex) {
		_tokenIndex = tokenIndex;
	}
	
	public String getSpecificToken(CommonTokenStream inputToken, int tokenIndex) {
		List<Token> tokens = inputToken.getTokens();
		String tokenText = tokens.get(_tokenIndex).getText();
		
		return tokenText;
	}
	
}
