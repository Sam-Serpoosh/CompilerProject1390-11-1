parser grammar ParserHandlerFirstIteration;

options {

  output = AST;
  tokenVocab = LexerHandlerFirstIteration;

}


@header {package com.jesus_mehdi.CompilerFiles;}

file 	:	 program {PostFirstIterationHandler postFirstIterationHandler = new PostFirstIterationHandler(); postFirstIterationHandler.checkErrors();} EOF;

program :	 (module SEMICOLON)+;

module 	:	 MODULE {ModuleHandler moduleHandler = new ModuleHandler(); moduleHandler.startModule();} ID {moduleHandler.setModuleName(input);}  (CHILD_OF ID {moduleHandler.setParentModuleName(input);})?
				 L_BRACE {moduleHandler.beginModuleScope();} (member)* R_BRACE {moduleHandler.endModuleScope();};

member	:	 {MethodHandler methodHandler = new MethodHandler();} (VIRTUAL {methodHandler.setVirtual();})? ID {methodHandler.setMethodName(input);} L_PAREN ( ID {methodHandler.addArgumentName(input);} COLON type {methodHandler.setArgumentType(input);} (COMMA ID {methodHandler.addArgumentName(input);} COLON type {methodHandler.setArgumentType(input);} )*)? R_PAREN COLON type {methodHandler.setReturnType(input);} L_BRACE st* R_BRACE {methodHandler.endMethodDeclaration();}
	|        ID {MemberHandler memberHandler = new MemberHandler(); memberHandler.setMemberName(input);} (L_BRACKET CONST_INT {memberHandler.setArraySize(input);} R_BRACKET)? COLON type {memberHandler.setType(input);} SEMICOLON {memberHandler.endMemberDeclaration();}
	;



st	:	L_BRACE (st)* R_BRACE
	| 	ID ( L_BRACKET CONST_INT R_BRACKET )? COLON type  SEMICOLON   ///    st_ to COLON
	|	e1 ( ASSIGN e1 )? SEMICOLON 			// newly added 
	| 	IF e1 THEN st (ELSE st)? END_IF
	| 	WHILE e1 LOOP	st ENDLOOP
	| 	BREAK SEMICOLON 
	| 	CONTINUE SEMICOLON 
	| 	READ ID SEMICOLON 
	|	WRITE e1 SEMICOLON 
	|	RETURN e1 SEMICOLON
	;

e1	:	(e2) (OR e2)*	;

e2	:	(e3) (AND e3)*	;

e3	:	NOT e4 		| e4	;

e4	:	(e5) (( RELOP_EQ | RELOP_NE ) e5)* ;

e5	:	(e6) (( RELOP_GT | RELOP_LT | RELOP_GE | RELOP_LE ) e6)*;

e6	:	(e7) ((PLUS | MINUS ) e7)*;

e7	:	(e8) (( SLASH | STAR ) e8)*;

e8	:	 MINUS e9 | e9;

e9	:	e10 (DOT e10)* ;

e10	:
	(	CREATE ID
	|	L_PAREN e1 R_PAREN
	|	CONST_INT | CONST_BOOL | CONST_STRING
	|	ID e11
	) 		
	;

e11	:	L_PAREN ( e1 (COMMA e1)* )? R_PAREN 
	| 	L_BRACKET e1 R_BRACKET
	|
	;

type	:	ID | TYPE_INT | TYPE_BOOL | TYPE_STRING | TYPE_VOID;