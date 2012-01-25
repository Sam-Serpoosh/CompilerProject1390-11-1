package com.jesus_mehdi.SemanticRulesHandlers;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import com.jesus_mehdi.DataStructures.Environment;
import com.jesus_mehdi.DataStructures.MemberSymbolTableRow;
import com.jesus_mehdi.DataStructures.SymbolTableRow;
import com.jesus_mehdi.Exceptions.DuplicateVariableDeclarationException;
import com.jesus_mehdi.Exceptions.MemberAndMethodExistWithSameNameException;

public class MemberHandler {

	private MemberSymbolTableRow _memberRow;
	private Tokenizer _tokenizer;
	
	public MemberHandler(Tokenizer tokenizer) {
		_tokenizer = tokenizer;
		_memberRow = new MemberSymbolTableRow();
	}
	
	public MemberHandler() {
		this(new Tokenizer());
	}
	
	public SymbolTableRow getMemberRow() {
		return _memberRow;
	}
	
	public void setMemberRow(MemberSymbolTableRow memberRow) {
		_memberRow = memberRow;
	}
	
	public void setMemberName(TokenStream input) {
		String variableName = _tokenizer.getSpecificToken((CommonTokenStream)input, -1);
		_memberRow.Name = variableName;
	}

	public void setType(TokenStream input) {
		String type = _tokenizer.getSpecificToken((CommonTokenStream)input, -1);
		_memberRow.Type = type;
	}
	
	public void setArraySize(TokenStream input) {
		String arraySizeToken = _tokenizer.getSpecificToken((CommonTokenStream)input, -1);
		int arraySize = Integer.parseInt(arraySizeToken);
		_memberRow.ArraySize = arraySize;
	}
	
	public void endMemberDeclaration() {
		Environment currentModuleEnvironment = Current.getScope();
		
		if (currentModuleEnvironment.rowAlreadyExisted(_memberRow)) {
			SymbolTableRow symbolTableRow = currentModuleEnvironment.getRow(_memberRow.Name);
			throwAppropriateDuplicateException(symbolTableRow);
		}
		
		currentModuleEnvironment.addRow(_memberRow);
	}

	private void throwAppropriateDuplicateException(
			SymbolTableRow symbolTableRow) {
		if(symbolTableRow instanceof MemberSymbolTableRow)
			throw new DuplicateVariableDeclarationException();
		else
			throw new MemberAndMethodExistWithSameNameException();
	}

}
