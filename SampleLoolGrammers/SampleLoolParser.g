parser grammar SampleLoolParser;

options {

  tokenVocab = SampleLoolLexer;

}

@header {package CompilerFiles;}

file 	:	 program EOF;
program	:	(decl{System.out.println("Kosse Nanant Ramak");})+;
type 	:	 TYPE_INT | TYPE_BOOL;
id	:	ID;
decl	:	 type id;