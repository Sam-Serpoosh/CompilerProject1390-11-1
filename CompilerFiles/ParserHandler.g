parser grammar ParserHandler;

options {

  output = AST;
  tokenVocab = LexerHandler;

}


@header {package com.jesus_mehdi.CompilerFiles;}

file 	:	 program EOF;

program :	 (module SEMICOLON)+;

module 	:	 MODULE {ModuleHandler moduleHandler = new ModuleHandler(); moduleHandler.startModule();} ID {moduleHandler.setModuleName(input);}  (CHILD_OF ID {moduleHandler.setParentModuleName(input);})?
				 L_BRACE {moduleHandler.beginModuleScope();} (member)* R_BRACE {moduleHandler.endModuleScope();};

member	:	 VIRTUAL? ID {MethodHandler methodHandler = new MethodHandler(); methodHandler.setMethodName(input);} L_PAREN ( ID {methodHandler.addArgumentName(input);} COLON type {methodHandler.setArgumentType(input);} (COMMA ID {methodHandler.addArgumentName(input);} COLON type {methodHandler.addArgumentType(input);} )*)? R_PAREN COLON type {methodHandler.setReturnType(input);} L_BRACE st* R_BRACE {methodHandler.endMethodDeclaration();}
	|        ID {MemberHandler memberHandler = new MemberHandler(); memberHandler.setName(input);} (L_BRACKET CONST_INT {memberHandler.setArraySize(input);} R_BRACKET)? COLON type {memberHandler.setType(input);} SEMICOLON {memberHandler.endDeclaration();}
	;



st	:	L_BRACE {System.out.println("{Block_Start}");} (st)* R_BRACE  {System.out.println("{Block_End}");}
	| 	ID ( L_BRACKET {System.out.println("{Array_Declaration}");} CONST_INT R_BRACKET )? COLON {System.out.println("{SympleType_Declaration}");} type  SEMICOLON   ///    st_ to COLON
	|	e1 ( ASSIGN e1 {System.out.println("{Assignment}");} )? SEMICOLON 			// newly added 
	| 	IF {System.out.println("{if_Clause}");} e1 THEN st (ELSE st)? END_IF
	| 	WHILE {System.out.println("{while_Loop}");} e1 LOOP	st ENDLOOP
	| 	BREAK SEMICOLON 
	| 	CONTINUE SEMICOLON 
	| 	READ ID SEMICOLON 
	|	WRITE e1 SEMICOLON 
	|	RETURN e1 {System.out.println("{return_Statement}");} SEMICOLON
	;

e1	:	(e2) (OR e2)*	;

e2	:	(e3) (AND e3)*	;

e3	:	NOT e4 		| e4	;

e4	:	(e5) (( RELOP_EQ | RELOP_NE ) e5)* ;

e5	:	(e6) (( RELOP_GT | RELOP_LT | RELOP_GE | RELOP_LE ) e6)*;

e6	:	(e7) ((PLUS {System.out.println("{Sum}");} | MINUS {System.out.println("{Minus}");} ) e7)*;

e7	:	(e8) (( SLASH {System.out.println("{Div}");} | STAR {System.out.println("{Mult}");} ) e8)*;

e8	:	 MINUS e9  {System.out.println("{unaryMinus}");}		| e9;

e9	:	e10 (DOT {System.out.println("{Access_Member}");} e10)* ;

e10	:
	(	CREATE {System.out.println("{Object_creation}");} ID
	|	L_PAREN e1 R_PAREN
	|	CONST_INT | CONST_BOOL | CONST_STRING
	|	ID e11
	) 		
	;

e11	:	( L_PAREN {System.out.println("{Function_Call}");} ( e1 (COMMA e1)* )? R_PAREN )?
	| 	L_BRACKET {System.out.println("{Array_Address_Calculation}");} e1 R_BRACKET
	;

type	:	ID | TYPE_INT | TYPE_BOOL | TYPE_STRING | TYPE_VOID;