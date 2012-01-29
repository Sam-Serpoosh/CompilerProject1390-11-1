parser grammar ParserHandlerSecondIteration;

options {

  output = AST;
  tokenVocab = LexerHandlerSecondIteration;

}


@header {package com.jesus_mehdi.CompilerFiles;}

file 	:	 program EOF;

program :	 (module SEMICOLON)+;

module 	:	 MODULE ID {ModuleHandler moduleHandler = new ModuleHandler(); moduleHandler.setCurrentScopeByModuleName(input);}(CHILD_OF ID )? L_BRACE (member)* R_BRACE ;

member	:	 (VIRTUAL)? ID L_PAREN ( ID COLON type (COMMA ID COLON type)*)? R_PAREN COLON type L_BRACE 
		 	{MethodHandler methodHandler = new MethodHandler(); methodHandler.beginMethodScope();} st* R_BRACE {methodHandler.endMethodScope();}
	|        ID (L_BRACKET CONST_INT R_BRACKET)? COLON type SEMICOLON
	;



st	:	L_BRACE {System.out.println("{Block_Start}");} (st)* R_BRACE  {System.out.println("{Block_End}");}
	| 	ID {MemberHandler memberHandler = new MemberHandler(); memberHandler.setMemberName(input);}( L_BRACKET CONST_INT {memberHandler.setArraySize(input);} R_BRACKET )? COLON type {memberHandler.setType(input);} SEMICOLON {memberHandler.endMemberDeclaration();}  ///    st_ to COLON
	|	{TypeCheckerFactory.createTypeChecker();}e1 ( ASSIGN e1 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.assignmentOperator();} )? SEMICOLON 			// newly added 
	| 	IF {System.out.println("{if_Clause}");} e1 THEN st (ELSE st)? END_IF
	| 	WHILE {System.out.println("{while_Loop}");} e1 LOOP	st ENDLOOP
	| 	BREAK SEMICOLON 
	| 	CONTINUE SEMICOLON 
	| 	READ ID SEMICOLON 
	|	WRITE e1 SEMICOLON 
	|	RETURN e1 {System.out.println("{return_Statement}");} SEMICOLON
	;

e1	:	(e2) (OR e2 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.orOperator();})*;

e2	:	(e3)(AND e3 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.orOperator();})*;

e3	:	NOT e4 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.notOperator();}		| e4	;

e4	:	(e5) (( RELOP_EQ | RELOP_NE ) e5 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.equalityRelationOperators();})* ;

e5	:	(e6) (( RELOP_GT | RELOP_LT | RELOP_GE | RELOP_LE ) e6 {TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.relationalOperator();})*;

e6	:	(e7) ((PLUS {System.out.println("{Sum}");} | MINUS {System.out.println("{Minus}");} ) e7)*;

e7	:	(e8) (( SLASH {System.out.println("{Div}");} | STAR {System.out.println("{Mult}");} ) e8)*;

e8	:	 MINUS e9  {System.out.println("{unaryMinus}");}		| e9;

e9	:	e10 (DOT {System.out.println("{Access_Member}");} e10)* ;

e10	:
	(	CREATE {System.out.println("{Object_creation}");} ID
	|	L_PAREN e1 R_PAREN
	|	{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker();}(CONST_INT{typeChecker.setConstIntInput();} | CONST_BOOL {typeChecker.setConstBoolInput();} | CONST_STRING {typeChecker.setConstStringInput();})
	|	ID e11
	) 		
	;

e11	:	L_PAREN {System.out.println("{Function_Call}");} ( e1 (COMMA e1)* )? R_PAREN 
	| 	L_BRACKET {System.out.println("{Array_Address_Calculation}");} e1 R_BRACKET
	|	{TypeChecker typeChecker = TypeCheckerFactory.getTypeChecker(); typeChecker.setInputId(input);}
	;

type	:	ID | TYPE_INT | TYPE_BOOL | TYPE_STRING | TYPE_VOID;