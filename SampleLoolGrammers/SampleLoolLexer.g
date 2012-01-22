lexer grammar SampleLoolLexer;

NEWLINE			:	('\r'? '\n')+					{skip();}		;
WHITESPACE		: 	(' ' | '\t')+ 					{skip();}		;

fragment LETTER: LOWER | UPPER;

TYPE_INT	:	'int'		;
TYPE_BOOL	:	'bool'		;

fragment LOWER : ('a'..'z');
fragment UPPER : ('A'..'Z');

ID  			:	( LETTER |'_') ( LETTER |'_' )*				;

