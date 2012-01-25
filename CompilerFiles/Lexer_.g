
lexer grammar Lexer_;

@header 	{ package com.jesus_mehdi.CompilerFiles; }

MODULE		:	'module'	;
CHILD_OF	:	'childof'	;
VIRTUAL		:	'virtual'	;
CREATE		:	'create'	;

RETURN		:	'return'	;

IF		:	'if'		;
THEN		:	'then'		;
ELSE		:	'else'		;
END_IF		:	'endif'		;

WHILE		:	'while'		;
LOOP		:	'loop'		;
ENDLOOP		:	'endloop'	;

BREAK		:	'break'		;
CONTINUE	:	'continue'	;

READ		:	'read'		;
WRITE		:	'write'		;

AND		:	'and'		;
NOT		:	'not'		;
OR		:	'or'		;

TYPE_VOID	:	'void'		;
TYPE_INT	:	'int'		;
TYPE_BOOL	:	'bool'		;
TYPE_STRING	:	'string'	;






CONST_BOOL	:	'true'|'false'					;

CONST_INT 	:	( ('0') | ('1'..'9')(DEC_DIGIT)* ) 	;

CONST_STRING	:  	'"' ( ESC_SEQ | ~('\\'|'"') )* '"'		;


PLUS			:	'+' 	;
MINUS			:	'-' 	;
STAR			:	'*' 	;
SLASH			:	'/' 	;

RELOP_GE		:	'>='	;
RELOP_LE		:	'<='	;
RELOP_GT		:	'>' 	;
RELOP_LT		:	'<'	;
RELOP_NE		:	'!='	;
RELOP_EQ		:	'='	;
	
ASSIGN			:	':='	;
COLON			: 	':'	; 
SEMICOLON		:	';' 	;
COMMA 			:	','	;
DOT			:	'.'	;

L_PAREN			:	'(' 	;
R_PAREN			:	')' 	; 

L_BRACKET		:	'[' 	;
R_BRACKET		:	']'	;

L_BRACE			:	'{'	; 
R_BRACE			:	'}' 	;



ID  			:	( LETTER |'_') ( LETTER |DEC_DIGIT |'_' )*				;


MULTILINE_COMMENT	:	'%%%' ( options {greedy=false;} : . )* '%%%' 	{skip();}	;
SINGLELINE_COMMENT	:	('%%') ~('\n'|'\r')* (EOF|'\r'? '\n') 		{skip();}	;


NEWLINE			:	('\r'? '\n')+					{skip();}		;
WHITESPACE		: 	(' ' | '\t')+ 					{skip();}		;


CHAR			:  	'\'' ( ESC_SEQ | ~('\''|'\\') ) '\''		;


ERROR1			:	 (DEC_DIGIT)+ ID 				;
ERROR2			:	~(LETTER|'_'|SYMBOL)				;
ERROR3			:	 (SIGN)?'0'(DEC_DIGIT)+ 			;			


/****************************************************************************************
*						 					*
*	
*	
*	
*	
*	
*	
*	
*											*
*****************************************************************************************/


fragment
SYMBOL		
    :	'>' | '<' | '=' |'!' | ':' | ';'  
    |   '(' | ')' | '[' | ']'| '{' | '}' 
    |	'+' | '-' | '*' | '/'
    ;

//*******************************************************


fragment LETTER: LOWER | UPPER;

fragment LOWER : ('a'..'z');
fragment UPPER : ('A'..'Z');

//*******************************************************

fragment SIGN:	'+'|'-';

fragment
DEC_DIGIT : ('0'..'9');

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;


//*******************************************************

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
