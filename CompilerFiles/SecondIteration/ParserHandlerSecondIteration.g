parser grammar ParserHandlerSecondIteration;

options {

  output = AST;
  tokenVocab = LexerHandlerSecondIteration;

}


@header {package com.jesus_mehdi.CompilerFiles;}

file 	:	 program EOF;

program :	 (module SEMICOLON)+;

module 	:	 MODULE ID {ModuleHandler moduleHandler = new ModuleHandler(); moduleHandler.setCurrentScopeByModuleName(input);}(CHILD_OF ID )? L_BRACE (member)* R_BRACE ;

member	:	 (VIRTUAL)? {MethodHandler methodHandler = new MethodHandler(); methodHandler.beginMethodScope();} 
			ID{methodHandler.setMethodEnvironmentName(input);} 
			L_PAREN ( ID{methodHandler.addArgumentNameToMethodEnvironment(input);} COLON type{methodHandler.setArgumentTypeInMethodEnvironment(input);} 
				(COMMA ID{methodHandler.addArgumentNameToMethodEnvironment(input);} COLON type{methodHandler.setArgumentTypeInMethodEnvironment(input);})*)? 
				R_PAREN COLON type{methodHandler.setReturnTypeInMethodEnvironment(input);} L_BRACE 
		 	st* R_BRACE {methodHandler.endMethodScope();}
	|        ID (L_BRACKET CONST_INT R_BRACKET)? COLON type SEMICOLON
	;



st	:	L_BRACE {System.out.println("{Block_Start}");} (st)* R_BRACE  {System.out.println("{Block_End}");}
	| 	ID {MemberHandler memberHandler = new MemberHandler(); memberHandler.setMemberName(input);}( L_BRACKET CONST_INT {memberHandler.setArraySize(input);} R_BRACKET )? COLON type {memberHandler.setType(input);} SEMICOLON {memberHandler.endMemberDeclaration();}  ///    st_ to COLON
	|	{TypeCheckerFactory.createTypeChecker();}e1 ( ASSIGN e1 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.assignmentOperator();} )? SEMICOLON 			// newly added 
	| 	IF e1{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.conditionExpressionShouldBeBoolean();} THEN st (ELSE st)? END_IF
	| 	WHILE e1 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.conditionExpressionShouldBeBoolean();} LOOP	st ENDLOOP
	| 	BREAK SEMICOLON 
	| 	CONTINUE SEMICOLON 
	| 	READ ID {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.checkValidityOfIdForRead();} SEMICOLON 
	|	WRITE e1 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.checkValidityOfIdForWrite();}SEMICOLON 
	|	RETURN e1 {System.out.println("{return_Statement}");} SEMICOLON
	;

e1	:	(e2) (OR e2 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.orOperator();})*;

e2	:	(e3)(AND e3 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.orOperator();})*;

e3	:	NOT e4 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.notOperator();}| e4	;

e4	:	(e5) (( RELOP_EQ | RELOP_NE ) e5 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.equalityRelationOperators();})* ;

e5	:	(e6) (( RELOP_GT | RELOP_LT | RELOP_GE | RELOP_LE ) e6 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.relationalOperator();})*;

e6	:	(e7) ((PLUS {System.out.println("{Sum}");} | MINUS {System.out.println("{Minus}");} ) e7{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.binaryMathematicalOperator();})*;

e7	:	(e8) (( SLASH {System.out.println("{Div}");} | STAR {System.out.println("{Mult}");} ) e8{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.binaryMathematicalOperator();})*;

e8	:	 MINUS e9  {{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.unaryMinusOperator();}}| e9;

e9	:	e10 (DOT {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.setInstanceScope(); typeChecker.changeToInstanceScope();} e10 {typeChecker.returnToCurrentScope();} )* ;


e11	:	{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.setMethodInputId(input);}L_PAREN {typeChecker.returnToCurrentScope();} ( e1 {typeChecker.pushParameter();}(COMMA e1 {typeChecker.pushParameter();})* )? R_PAREN {typeChecker.changeToInstanceScope(); typeChecker.endMethodCall();}
	| 	{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.setArrayInputId(input);} L_BRACKET {typeChecker.returnToCurrentScope();} e1 {typeChecker.checkArrayIndexType();} R_BRACKET {typeChecker.changeToInstanceScope();}
	|	{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.setInputId(input); typeChecker.returnToCurrentScope();}
	;
e10	:
	(	CREATE ID {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.checkValidityOfIdForCreation();}
	|	L_PAREN e1 R_PAREN
	|	{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker();}(CONST_INT{typeChecker.setConstIntInput();} | CONST_BOOL {typeChecker.setConstBoolInput();} | CONST_STRING {typeChecker.setConstStringInput();})
	|	ID e11
	) 		
	;


type	:	ID | TYPE_INT | TYPE_BOOL | TYPE_STRING | TYPE_VOID;