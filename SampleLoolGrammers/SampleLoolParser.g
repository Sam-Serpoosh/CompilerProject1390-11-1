parser grammar SampleLoolParser;

options {

  tokenVocab = SampleLoolLexer;

}

@header {package CompilerFiles;}

file 	:	 program EOF;
program	:	(decl{Fuck.fuckYou();})+;
type 	:	 TYPE_INT | TYPE_BOOL;
id	:	ID;
decl	:	 type id;