// $ANTLR 3.4 C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g 2012-01-28 12:56:39
 package com.jesus_mehdi.CompilerFiles; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class LexerHandlerFirstIteration extends Lexer {
    public static final int EOF=-1;
    public static final int AND=4;
    public static final int ASSIGN=5;
    public static final int BREAK=6;
    public static final int CHAR=7;
    public static final int CHILD_OF=8;
    public static final int COLON=9;
    public static final int COMMA=10;
    public static final int CONST_BOOL=11;
    public static final int CONST_INT=12;
    public static final int CONST_STRING=13;
    public static final int CONTINUE=14;
    public static final int CREATE=15;
    public static final int DEC_DIGIT=16;
    public static final int DOT=17;
    public static final int ELSE=18;
    public static final int ENDLOOP=19;
    public static final int END_IF=20;
    public static final int ERROR1=21;
    public static final int ERROR2=22;
    public static final int ERROR3=23;
    public static final int ESC_SEQ=24;
    public static final int HEX_DIGIT=25;
    public static final int ID=26;
    public static final int IF=27;
    public static final int LETTER=28;
    public static final int LOOP=29;
    public static final int LOWER=30;
    public static final int L_BRACE=31;
    public static final int L_BRACKET=32;
    public static final int L_PAREN=33;
    public static final int MINUS=34;
    public static final int MODULE=35;
    public static final int MULTILINE_COMMENT=36;
    public static final int NEWLINE=37;
    public static final int NOT=38;
    public static final int OCTAL_ESC=39;
    public static final int OR=40;
    public static final int PLUS=41;
    public static final int READ=42;
    public static final int RELOP_EQ=43;
    public static final int RELOP_GE=44;
    public static final int RELOP_GT=45;
    public static final int RELOP_LE=46;
    public static final int RELOP_LT=47;
    public static final int RELOP_NE=48;
    public static final int RETURN=49;
    public static final int R_BRACE=50;
    public static final int R_BRACKET=51;
    public static final int R_PAREN=52;
    public static final int SEMICOLON=53;
    public static final int SIGN=54;
    public static final int SINGLELINE_COMMENT=55;
    public static final int SLASH=56;
    public static final int STAR=57;
    public static final int SYMBOL=58;
    public static final int THEN=59;
    public static final int TYPE_BOOL=60;
    public static final int TYPE_INT=61;
    public static final int TYPE_STRING=62;
    public static final int TYPE_VOID=63;
    public static final int UNICODE_ESC=64;
    public static final int UPPER=65;
    public static final int VIRTUAL=66;
    public static final int WHILE=67;
    public static final int WHITESPACE=68;
    public static final int WRITE=69;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public LexerHandlerFirstIteration() {} 
    public LexerHandlerFirstIteration(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LexerHandlerFirstIteration(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g"; }

    // $ANTLR start "MODULE"
    public final void mMODULE() throws RecognitionException {
        try {
            int _type = MODULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:6:9: ( 'module' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:6:11: 'module'
            {
            match("module"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MODULE"

    // $ANTLR start "CHILD_OF"
    public final void mCHILD_OF() throws RecognitionException {
        try {
            int _type = CHILD_OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:7:10: ( 'childof' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:7:12: 'childof'
            {
            match("childof"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHILD_OF"

    // $ANTLR start "VIRTUAL"
    public final void mVIRTUAL() throws RecognitionException {
        try {
            int _type = VIRTUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:8:10: ( 'virtual' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:8:12: 'virtual'
            {
            match("virtual"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VIRTUAL"

    // $ANTLR start "CREATE"
    public final void mCREATE() throws RecognitionException {
        try {
            int _type = CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:9:9: ( 'create' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:9:11: 'create'
            {
            match("create"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CREATE"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:11:9: ( 'return' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:11:11: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:13:5: ( 'if' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:13:7: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:14:7: ( 'then' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:14:9: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:15:7: ( 'else' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:15:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "END_IF"
    public final void mEND_IF() throws RecognitionException {
        try {
            int _type = END_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:16:9: ( 'endif' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:16:11: 'endif'
            {
            match("endif"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END_IF"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:18:8: ( 'while' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:18:10: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "LOOP"
    public final void mLOOP() throws RecognitionException {
        try {
            int _type = LOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:19:7: ( 'loop' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:19:9: 'loop'
            {
            match("loop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOOP"

    // $ANTLR start "ENDLOOP"
    public final void mENDLOOP() throws RecognitionException {
        try {
            int _type = ENDLOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:20:10: ( 'endloop' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:20:12: 'endloop'
            {
            match("endloop"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ENDLOOP"

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:22:8: ( 'break' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:22:10: 'break'
            {
            match("break"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "CONTINUE"
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:23:10: ( 'continue' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:23:12: 'continue'
            {
            match("continue"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONTINUE"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:25:7: ( 'read' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:25:9: 'read'
            {
            match("read"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "WRITE"
    public final void mWRITE() throws RecognitionException {
        try {
            int _type = WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:26:8: ( 'write' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:26:10: 'write'
            {
            match("write"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WRITE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:28:6: ( 'and' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:28:8: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:29:6: ( 'not' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:29:8: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:30:5: ( 'or' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:30:7: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "TYPE_VOID"
    public final void mTYPE_VOID() throws RecognitionException {
        try {
            int _type = TYPE_VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:32:11: ( 'void' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:32:13: 'void'
            {
            match("void"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE_VOID"

    // $ANTLR start "TYPE_INT"
    public final void mTYPE_INT() throws RecognitionException {
        try {
            int _type = TYPE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:33:10: ( 'int' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:33:12: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE_INT"

    // $ANTLR start "TYPE_BOOL"
    public final void mTYPE_BOOL() throws RecognitionException {
        try {
            int _type = TYPE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:34:11: ( 'bool' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:34:13: 'bool'
            {
            match("bool"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE_BOOL"

    // $ANTLR start "TYPE_STRING"
    public final void mTYPE_STRING() throws RecognitionException {
        try {
            int _type = TYPE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:35:13: ( 'string' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:35:15: 'string'
            {
            match("string"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE_STRING"

    // $ANTLR start "CONST_BOOL"
    public final void mCONST_BOOL() throws RecognitionException {
        try {
            int _type = CONST_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:42:12: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:42:14: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:42:21: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONST_BOOL"

    // $ANTLR start "CONST_INT"
    public final void mCONST_INT() throws RecognitionException {
        try {
            int _type = CONST_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:12: ( ( ( '0' ) | ( '1' .. '9' ) ( DEC_DIGIT )* ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:14: ( ( '0' ) | ( '1' .. '9' ) ( DEC_DIGIT )* )
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:14: ( ( '0' ) | ( '1' .. '9' ) ( DEC_DIGIT )* )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='0') ) {
                alt3=1;
            }
            else if ( ((LA3_0 >= '1' && LA3_0 <= '9')) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:16: ( '0' )
                    {
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:16: ( '0' )
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:17: '0'
                    {
                    match('0'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:24: ( '1' .. '9' ) ( DEC_DIGIT )*
                    {
                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:44:34: ( DEC_DIGIT )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONST_INT"

    // $ANTLR start "CONST_STRING"
    public final void mCONST_STRING() throws RecognitionException {
        try {
            int _type = CONST_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:46:14: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:46:18: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:46:22: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:46:24: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:46:34: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONST_STRING"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:49:8: ( '+' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:49:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:50:9: ( '-' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:50:11: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:51:8: ( '*' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:51:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:52:9: ( '/' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:52:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "RELOP_GE"
    public final void mRELOP_GE() throws RecognitionException {
        try {
            int _type = RELOP_GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:54:11: ( '>=' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:54:13: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP_GE"

    // $ANTLR start "RELOP_LE"
    public final void mRELOP_LE() throws RecognitionException {
        try {
            int _type = RELOP_LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:55:11: ( '<=' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:55:13: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP_LE"

    // $ANTLR start "RELOP_GT"
    public final void mRELOP_GT() throws RecognitionException {
        try {
            int _type = RELOP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:56:11: ( '>' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:56:13: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP_GT"

    // $ANTLR start "RELOP_LT"
    public final void mRELOP_LT() throws RecognitionException {
        try {
            int _type = RELOP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:57:11: ( '<' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:57:13: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP_LT"

    // $ANTLR start "RELOP_NE"
    public final void mRELOP_NE() throws RecognitionException {
        try {
            int _type = RELOP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:58:11: ( '!=' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:58:13: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP_NE"

    // $ANTLR start "RELOP_EQ"
    public final void mRELOP_EQ() throws RecognitionException {
        try {
            int _type = RELOP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:59:11: ( '=' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:59:13: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP_EQ"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:61:10: ( ':=' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:61:12: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:62:9: ( ':' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:62:12: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:63:12: ( ';' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:63:14: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:64:10: ( ',' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:64:12: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:65:7: ( '.' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:65:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "L_PAREN"
    public final void mL_PAREN() throws RecognitionException {
        try {
            int _type = L_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:67:11: ( '(' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:67:13: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "L_PAREN"

    // $ANTLR start "R_PAREN"
    public final void mR_PAREN() throws RecognitionException {
        try {
            int _type = R_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:68:11: ( ')' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:68:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "R_PAREN"

    // $ANTLR start "L_BRACKET"
    public final void mL_BRACKET() throws RecognitionException {
        try {
            int _type = L_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:70:12: ( '[' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:70:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "L_BRACKET"

    // $ANTLR start "R_BRACKET"
    public final void mR_BRACKET() throws RecognitionException {
        try {
            int _type = R_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:71:12: ( ']' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:71:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "R_BRACKET"

    // $ANTLR start "L_BRACE"
    public final void mL_BRACE() throws RecognitionException {
        try {
            int _type = L_BRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:73:11: ( '{' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:73:13: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "L_BRACE"

    // $ANTLR start "R_BRACE"
    public final void mR_BRACE() throws RecognitionException {
        try {
            int _type = R_BRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:74:11: ( '}' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:74:13: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "R_BRACE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:78:8: ( ( LETTER | '_' ) ( LETTER | DEC_DIGIT | '_' )* )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:78:10: ( LETTER | '_' ) ( LETTER | DEC_DIGIT | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:78:25: ( LETTER | DEC_DIGIT | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:81:19: ( '%%%' ( options {greedy=false; } : . )* '%%%' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:81:21: '%%%' ( options {greedy=false; } : . )* '%%%'
            {
            match("%%%"); 



            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:81:27: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='%') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='%') ) {
                        int LA6_3 = input.LA(3);

                        if ( (LA6_3=='%') ) {
                            alt6=2;
                        }
                        else if ( ((LA6_3 >= '\u0000' && LA6_3 <= '$')||(LA6_3 >= '&' && LA6_3 <= '\uFFFF')) ) {
                            alt6=1;
                        }


                    }
                    else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '$')||(LA6_1 >= '&' && LA6_1 <= '\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '$')||(LA6_0 >= '&' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:81:55: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match("%%%"); 



            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    // $ANTLR start "SINGLELINE_COMMENT"
    public final void mSINGLELINE_COMMENT() throws RecognitionException {
        try {
            int _type = SINGLELINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:20: ( ( '%%' ) (~ ( '\\n' | '\\r' ) )* ( EOF | ( '\\r' )? '\\n' ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:22: ( '%%' ) (~ ( '\\n' | '\\r' ) )* ( EOF | ( '\\r' )? '\\n' )
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:22: ( '%%' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:23: '%%'
            {
            match("%%"); 



            }


            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:29: (~ ( '\\n' | '\\r' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:43: ( EOF | ( '\\r' )? '\\n' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=2;
            }
            else {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:44: EOF
                    {
                    match(EOF); 


                    }
                    break;
                case 2 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:48: ( '\\r' )? '\\n'
                    {
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:48: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:82:48: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;

            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SINGLELINE_COMMENT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:85:11: ( ( ( '\\r' )? '\\n' )+ )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:85:13: ( ( '\\r' )? '\\n' )+
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:85:13: ( ( '\\r' )? '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:85:14: ( '\\r' )? '\\n'
            	    {
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:85:14: ( '\\r' )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0=='\r') ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:85:14: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }


            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:86:13: ( ( ' ' | '\\t' )+ )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:86:16: ( ' ' | '\\t' )+
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:86:16: ( ' ' | '\\t' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\t'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:89:8: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:89:12: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:89:17: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\\') ) {
                alt13=1;
            }
            else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '&')||(LA13_0 >= '(' && LA13_0 <= '[')||(LA13_0 >= ']' && LA13_0 <= '\uFFFF')) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:89:19: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:89:29: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "ERROR1"
    public final void mERROR1() throws RecognitionException {
        try {
            int _type = ERROR1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:92:10: ( ( DEC_DIGIT )+ ID )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:92:13: ( DEC_DIGIT )+ ID
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:92:13: ( DEC_DIGIT )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            mID(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ERROR1"

    // $ANTLR start "ERROR2"
    public final void mERROR2() throws RecognitionException {
        try {
            int _type = ERROR2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:93:10: (~ ( LETTER | '_' | SYMBOL ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( (input.LA(1) >= '\u0000' && input.LA(1) <= ' ')||(input.LA(1) >= '\"' && input.LA(1) <= '\'')||input.LA(1)==','||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= '?' && input.LA(1) <= '@')||input.LA(1)=='\\'||input.LA(1)=='^'||input.LA(1)=='`'||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ERROR2"

    // $ANTLR start "ERROR3"
    public final void mERROR3() throws RecognitionException {
        try {
            int _type = ERROR3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:94:10: ( ( SIGN )? '0' ( DEC_DIGIT )+ )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:94:13: ( SIGN )? '0' ( DEC_DIGIT )+
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:94:13: ( SIGN )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='+'||LA15_0=='-') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('0'); 

            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:94:23: ( DEC_DIGIT )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= '0' && LA16_0 <= '9')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ERROR3"

    // $ANTLR start "SYMBOL"
    public final void mSYMBOL() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:112:5: ( '>' | '<' | '=' | '!' | ':' | ';' | '(' | ')' | '[' | ']' | '{' | '}' | '+' | '-' | '*' | '/' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( input.LA(1)=='!'||(input.LA(1) >= '(' && input.LA(1) <= '+')||input.LA(1)=='-'||input.LA(1)=='/'||(input.LA(1) >= ':' && input.LA(1) <= '>')||input.LA(1)=='['||input.LA(1)==']'||input.LA(1)=='{'||input.LA(1)=='}' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SYMBOL"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:120:16: ( LOWER | UPPER )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "LOWER"
    public final void mLOWER() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:122:16: ( ( 'a' .. 'z' ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOWER"

    // $ANTLR start "UPPER"
    public final void mUPPER() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:123:16: ( ( 'A' .. 'Z' ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UPPER"

    // $ANTLR start "SIGN"
    public final void mSIGN() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:127:14: ( '+' | '-' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SIGN"

    // $ANTLR start "DEC_DIGIT"
    public final void mDEC_DIGIT() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:130:11: ( ( '0' .. '9' ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEC_DIGIT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:133:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:140:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt17=1;
                    }
                    break;
                case 'u':
                    {
                    alt17=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt17=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:140:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:141:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:142:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:147:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\\') ) {
                int LA18_1 = input.LA(2);

                if ( ((LA18_1 >= '0' && LA18_1 <= '3')) ) {
                    int LA18_2 = input.LA(3);

                    if ( ((LA18_2 >= '0' && LA18_2 <= '7')) ) {
                        int LA18_4 = input.LA(4);

                        if ( ((LA18_4 >= '0' && LA18_4 <= '7')) ) {
                            alt18=1;
                        }
                        else {
                            alt18=2;
                        }
                    }
                    else {
                        alt18=3;
                    }
                }
                else if ( ((LA18_1 >= '4' && LA18_1 <= '7')) ) {
                    int LA18_3 = input.LA(3);

                    if ( ((LA18_3 >= '0' && LA18_3 <= '7')) ) {
                        alt18=2;
                    }
                    else {
                        alt18=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:147:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:148:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:149:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:154:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:154:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:8: ( MODULE | CHILD_OF | VIRTUAL | CREATE | RETURN | IF | THEN | ELSE | END_IF | WHILE | LOOP | ENDLOOP | BREAK | CONTINUE | READ | WRITE | AND | NOT | OR | TYPE_VOID | TYPE_INT | TYPE_BOOL | TYPE_STRING | CONST_BOOL | CONST_INT | CONST_STRING | PLUS | MINUS | STAR | SLASH | RELOP_GE | RELOP_LE | RELOP_GT | RELOP_LT | RELOP_NE | RELOP_EQ | ASSIGN | COLON | SEMICOLON | COMMA | DOT | L_PAREN | R_PAREN | L_BRACKET | R_BRACKET | L_BRACE | R_BRACE | ID | MULTILINE_COMMENT | SINGLELINE_COMMENT | NEWLINE | WHITESPACE | CHAR | ERROR1 | ERROR2 | ERROR3 )
        int alt19=56;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:10: MODULE
                {
                mMODULE(); 


                }
                break;
            case 2 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:17: CHILD_OF
                {
                mCHILD_OF(); 


                }
                break;
            case 3 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:26: VIRTUAL
                {
                mVIRTUAL(); 


                }
                break;
            case 4 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:34: CREATE
                {
                mCREATE(); 


                }
                break;
            case 5 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:41: RETURN
                {
                mRETURN(); 


                }
                break;
            case 6 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:48: IF
                {
                mIF(); 


                }
                break;
            case 7 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:51: THEN
                {
                mTHEN(); 


                }
                break;
            case 8 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:56: ELSE
                {
                mELSE(); 


                }
                break;
            case 9 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:61: END_IF
                {
                mEND_IF(); 


                }
                break;
            case 10 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:68: WHILE
                {
                mWHILE(); 


                }
                break;
            case 11 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:74: LOOP
                {
                mLOOP(); 


                }
                break;
            case 12 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:79: ENDLOOP
                {
                mENDLOOP(); 


                }
                break;
            case 13 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:87: BREAK
                {
                mBREAK(); 


                }
                break;
            case 14 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:93: CONTINUE
                {
                mCONTINUE(); 


                }
                break;
            case 15 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:102: READ
                {
                mREAD(); 


                }
                break;
            case 16 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:107: WRITE
                {
                mWRITE(); 


                }
                break;
            case 17 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:113: AND
                {
                mAND(); 


                }
                break;
            case 18 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:117: NOT
                {
                mNOT(); 


                }
                break;
            case 19 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:121: OR
                {
                mOR(); 


                }
                break;
            case 20 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:124: TYPE_VOID
                {
                mTYPE_VOID(); 


                }
                break;
            case 21 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:134: TYPE_INT
                {
                mTYPE_INT(); 


                }
                break;
            case 22 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:143: TYPE_BOOL
                {
                mTYPE_BOOL(); 


                }
                break;
            case 23 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:153: TYPE_STRING
                {
                mTYPE_STRING(); 


                }
                break;
            case 24 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:165: CONST_BOOL
                {
                mCONST_BOOL(); 


                }
                break;
            case 25 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:176: CONST_INT
                {
                mCONST_INT(); 


                }
                break;
            case 26 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:186: CONST_STRING
                {
                mCONST_STRING(); 


                }
                break;
            case 27 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:199: PLUS
                {
                mPLUS(); 


                }
                break;
            case 28 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:204: MINUS
                {
                mMINUS(); 


                }
                break;
            case 29 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:210: STAR
                {
                mSTAR(); 


                }
                break;
            case 30 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:215: SLASH
                {
                mSLASH(); 


                }
                break;
            case 31 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:221: RELOP_GE
                {
                mRELOP_GE(); 


                }
                break;
            case 32 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:230: RELOP_LE
                {
                mRELOP_LE(); 


                }
                break;
            case 33 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:239: RELOP_GT
                {
                mRELOP_GT(); 


                }
                break;
            case 34 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:248: RELOP_LT
                {
                mRELOP_LT(); 


                }
                break;
            case 35 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:257: RELOP_NE
                {
                mRELOP_NE(); 


                }
                break;
            case 36 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:266: RELOP_EQ
                {
                mRELOP_EQ(); 


                }
                break;
            case 37 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:275: ASSIGN
                {
                mASSIGN(); 


                }
                break;
            case 38 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:282: COLON
                {
                mCOLON(); 


                }
                break;
            case 39 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:288: SEMICOLON
                {
                mSEMICOLON(); 


                }
                break;
            case 40 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:298: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 41 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:304: DOT
                {
                mDOT(); 


                }
                break;
            case 42 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:308: L_PAREN
                {
                mL_PAREN(); 


                }
                break;
            case 43 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:316: R_PAREN
                {
                mR_PAREN(); 


                }
                break;
            case 44 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:324: L_BRACKET
                {
                mL_BRACKET(); 


                }
                break;
            case 45 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:334: R_BRACKET
                {
                mR_BRACKET(); 


                }
                break;
            case 46 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:344: L_BRACE
                {
                mL_BRACE(); 


                }
                break;
            case 47 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:352: R_BRACE
                {
                mR_BRACE(); 


                }
                break;
            case 48 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:360: ID
                {
                mID(); 


                }
                break;
            case 49 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:363: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 


                }
                break;
            case 50 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:381: SINGLELINE_COMMENT
                {
                mSINGLELINE_COMMENT(); 


                }
                break;
            case 51 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:400: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 52 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:408: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 53 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:419: CHAR
                {
                mCHAR(); 


                }
                break;
            case 54 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:424: ERROR1
                {
                mERROR1(); 


                }
                break;
            case 55 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:431: ERROR2
                {
                mERROR2(); 


                }
                break;
            case 56 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\FirstIteration\\LexerHandlerFirstIteration.g:1:438: ERROR3
                {
                mERROR3(); 


                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\17\45\2\103\1\53\1\110\1\112\2\uffff\1\114\1\116\2\uffff"+
        "\1\120\12\uffff\2\53\2\uffff\1\53\1\uffff\7\45\1\137\14\45\1\154"+
        "\2\45\2\uffff\1\111\1\103\14\uffff\1\160\3\uffff\10\45\1\uffff\1"+
        "\171\11\45\1\u0084\1\u0085\1\uffff\2\45\1\160\1\uffff\5\45\1\u0091"+
        "\1\45\1\u0093\1\uffff\1\u0094\1\u0095\1\u0096\4\45\1\u009b\1\45"+
        "\1\u009d\2\uffff\2\45\1\160\1\uffff\2\160\5\45\1\uffff\1\45\4\uffff"+
        "\1\u00a8\1\45\1\u00aa\1\u00ab\1\uffff\1\u00ac\1\uffff\1\45\1\u0095"+
        "\1\160\1\uffff\1\u00af\1\45\1\u00b1\2\45\1\u00b4\1\uffff\1\45\3"+
        "\uffff\1\u00b6\1\u00a1\1\uffff\1\u00b7\1\uffff\1\45\1\u00b9\1\uffff"+
        "\1\u00ba\2\uffff\1\u00bb\3\uffff";
    static final String DFA19_eofS =
        "\u00bc\uffff";
    static final String DFA19_minS =
        "\1\0\1\157\1\150\1\151\1\145\1\146\1\150\1\154\1\150\2\157\1\156"+
        "\1\157\1\162\1\164\1\141\2\60\1\0\2\60\2\uffff\2\75\2\uffff\1\75"+
        "\12\uffff\1\45\1\12\2\uffff\1\0\1\uffff\1\144\1\151\1\145\1\156"+
        "\1\162\1\151\1\141\1\60\1\164\1\145\1\165\1\163\1\144\2\151\1\157"+
        "\1\145\1\157\1\144\1\164\1\60\1\162\1\154\2\uffff\2\60\14\uffff"+
        "\1\45\3\uffff\1\165\1\154\1\141\2\164\1\144\1\165\1\144\1\uffff"+
        "\1\60\1\156\2\145\1\151\1\154\1\164\1\160\1\141\1\154\2\60\1\uffff"+
        "\1\151\1\163\1\0\1\uffff\1\154\1\144\1\164\1\151\1\165\1\60\1\162"+
        "\1\60\1\uffff\3\60\1\146\1\157\2\145\1\60\1\153\1\60\2\uffff\1\156"+
        "\1\145\4\0\1\145\1\157\1\145\1\156\1\141\1\uffff\1\156\4\uffff\1"+
        "\60\1\157\2\60\1\uffff\1\60\1\uffff\1\147\1\60\1\0\1\uffff\1\60"+
        "\1\146\1\60\1\165\1\154\1\60\1\uffff\1\160\3\uffff\1\60\1\0\1\uffff"+
        "\1\60\1\uffff\1\145\1\60\1\uffff\1\60\2\uffff\1\60\3\uffff";
    static final String DFA19_maxS =
        "\1\uffff\1\157\1\162\1\157\1\145\1\156\1\162\1\156\1\162\1\157\1"+
        "\162\1\156\1\157\1\162\1\164\1\141\2\172\1\uffff\2\60\2\uffff\2"+
        "\75\2\uffff\1\75\12\uffff\1\45\1\12\2\uffff\1\uffff\1\uffff\1\144"+
        "\1\151\1\145\1\156\1\162\1\151\1\164\1\172\1\164\1\145\1\165\1\163"+
        "\1\144\2\151\1\157\1\145\1\157\1\144\1\164\1\172\1\162\1\154\2\uffff"+
        "\2\172\14\uffff\1\45\3\uffff\1\165\1\154\1\141\2\164\1\144\1\165"+
        "\1\144\1\uffff\1\172\1\156\2\145\2\154\1\164\1\160\1\141\1\154\2"+
        "\172\1\uffff\1\151\1\163\1\uffff\1\uffff\1\154\1\144\1\164\1\151"+
        "\1\165\1\172\1\162\1\172\1\uffff\3\172\1\146\1\157\2\145\1\172\1"+
        "\153\1\172\2\uffff\1\156\1\145\4\uffff\1\145\1\157\1\145\1\156\1"+
        "\141\1\uffff\1\156\4\uffff\1\172\1\157\2\172\1\uffff\1\172\1\uffff"+
        "\1\147\1\172\1\uffff\1\uffff\1\172\1\146\1\172\1\165\1\154\1\172"+
        "\1\uffff\1\160\3\uffff\1\172\1\uffff\1\uffff\1\172\1\uffff\1\145"+
        "\1\172\1\uffff\1\172\2\uffff\1\172\3\uffff";
    static final String DFA19_acceptS =
        "\25\uffff\1\35\1\36\2\uffff\1\43\1\44\1\uffff\1\47\1\50\1\51\1\52"+
        "\1\53\1\54\1\55\1\56\1\57\1\60\2\uffff\1\63\1\64\1\uffff\1\67\27"+
        "\uffff\1\31\1\66\2\uffff\1\32\1\33\1\70\1\34\1\37\1\41\1\40\1\42"+
        "\1\45\1\46\1\50\1\51\1\uffff\1\63\1\64\1\65\10\uffff\1\6\14\uffff"+
        "\1\23\3\uffff\1\62\10\uffff\1\25\12\uffff\1\21\1\22\13\uffff\1\24"+
        "\1\uffff\1\17\1\7\1\30\1\10\4\uffff\1\13\1\uffff\1\26\3\uffff\1"+
        "\61\6\uffff\1\11\1\uffff\1\12\1\20\1\15\2\uffff\1\1\1\uffff\1\4"+
        "\2\uffff\1\5\1\uffff\1\27\1\2\1\uffff\1\3\1\14\1\16";
    static final String DFA19_specialS =
        "\1\1\21\uffff\1\6\27\uffff\1\0\104\uffff\1\3\30\uffff\1\11\1\7\1"+
        "\5\1\2\24\uffff\1\10\15\uffff\1\4\15\uffff}>";
    static final String[] DFA19_transitionS = {
            "\11\53\1\51\1\50\2\53\1\47\22\53\1\51\1\31\1\22\2\53\1\46\1"+
            "\53\1\52\1\37\1\40\1\25\1\23\1\35\1\24\1\36\1\26\1\20\11\21"+
            "\1\33\1\34\1\30\1\32\1\27\2\53\32\45\1\41\1\53\1\42\1\53\1\45"+
            "\1\53\1\13\1\12\1\2\1\45\1\7\1\17\2\45\1\5\2\45\1\11\1\1\1\14"+
            "\1\15\2\45\1\4\1\16\1\6\1\45\1\3\1\10\3\45\1\43\1\53\1\44\uff82"+
            "\53",
            "\1\54",
            "\1\55\6\uffff\1\57\2\uffff\1\56",
            "\1\60\5\uffff\1\61",
            "\1\62",
            "\1\63\7\uffff\1\64",
            "\1\65\11\uffff\1\66",
            "\1\67\1\uffff\1\70",
            "\1\71\11\uffff\1\72",
            "\1\73",
            "\1\75\2\uffff\1\74",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\12\105\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "\12\106\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "\0\107",
            "\1\111",
            "\1\111",
            "",
            "",
            "\1\113",
            "\1\115",
            "",
            "",
            "\1\117",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "\1\124",
            "",
            "",
            "\47\126\1\uffff\uffd8\126",
            "",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\136\22\uffff\1\135",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\155",
            "\1\156",
            "",
            "",
            "\12\105\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "\12\106\7\uffff\32\104\4\uffff\1\104\1\uffff\32\104",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157",
            "",
            "",
            "",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175\2\uffff\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u0086",
            "\1\u0087",
            "\12\u008b\1\u008a\2\u008b\1\u0089\27\u008b\1\u0088\uffda\u008b",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0092",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u009c",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\1\u009e",
            "\1\u009f",
            "\12\u008b\1\u008a\2\u008b\1\u0089\27\u008b\1\u00a0\uffda\u008b",
            "\12\u00a1\1\u008a\ufff5\u00a1",
            "\0\u00a1",
            "\12\u008b\1\u008a\2\u008b\1\u0089\27\u008b\1\u0088\uffda\u008b",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\1\u00a7",
            "",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00a9",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u00ad",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\u008b\1\u008a\2\u008b\1\u0089\27\u008b\1\u00ae\uffda\u008b",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00b0",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00b2",
            "\1\u00b3",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u00b5",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\u008b\1\u008a\2\u008b\1\u0089\27\u008b\1\u00ae\uffda\u008b",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u00b8",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( MODULE | CHILD_OF | VIRTUAL | CREATE | RETURN | IF | THEN | ELSE | END_IF | WHILE | LOOP | ENDLOOP | BREAK | CONTINUE | READ | WRITE | AND | NOT | OR | TYPE_VOID | TYPE_INT | TYPE_BOOL | TYPE_STRING | CONST_BOOL | CONST_INT | CONST_STRING | PLUS | MINUS | STAR | SLASH | RELOP_GE | RELOP_LE | RELOP_GT | RELOP_LT | RELOP_NE | RELOP_EQ | ASSIGN | COLON | SEMICOLON | COMMA | DOT | L_PAREN | R_PAREN | L_BRACKET | R_BRACKET | L_BRACE | R_BRACE | ID | MULTILINE_COMMENT | SINGLELINE_COMMENT | NEWLINE | WHITESPACE | CHAR | ERROR1 | ERROR2 | ERROR3 );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_42 = input.LA(1);

                        s = -1;
                        if ( ((LA19_42 >= '\u0000' && LA19_42 <= '&')||(LA19_42 >= '(' && LA19_42 <= '\uFFFF')) ) {s = 86;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA19_0 = input.LA(1);

                        s = -1;
                        if ( (LA19_0=='m') ) {s = 1;}

                        else if ( (LA19_0=='c') ) {s = 2;}

                        else if ( (LA19_0=='v') ) {s = 3;}

                        else if ( (LA19_0=='r') ) {s = 4;}

                        else if ( (LA19_0=='i') ) {s = 5;}

                        else if ( (LA19_0=='t') ) {s = 6;}

                        else if ( (LA19_0=='e') ) {s = 7;}

                        else if ( (LA19_0=='w') ) {s = 8;}

                        else if ( (LA19_0=='l') ) {s = 9;}

                        else if ( (LA19_0=='b') ) {s = 10;}

                        else if ( (LA19_0=='a') ) {s = 11;}

                        else if ( (LA19_0=='n') ) {s = 12;}

                        else if ( (LA19_0=='o') ) {s = 13;}

                        else if ( (LA19_0=='s') ) {s = 14;}

                        else if ( (LA19_0=='f') ) {s = 15;}

                        else if ( (LA19_0=='0') ) {s = 16;}

                        else if ( ((LA19_0 >= '1' && LA19_0 <= '9')) ) {s = 17;}

                        else if ( (LA19_0=='\"') ) {s = 18;}

                        else if ( (LA19_0=='+') ) {s = 19;}

                        else if ( (LA19_0=='-') ) {s = 20;}

                        else if ( (LA19_0=='*') ) {s = 21;}

                        else if ( (LA19_0=='/') ) {s = 22;}

                        else if ( (LA19_0=='>') ) {s = 23;}

                        else if ( (LA19_0=='<') ) {s = 24;}

                        else if ( (LA19_0=='!') ) {s = 25;}

                        else if ( (LA19_0=='=') ) {s = 26;}

                        else if ( (LA19_0==':') ) {s = 27;}

                        else if ( (LA19_0==';') ) {s = 28;}

                        else if ( (LA19_0==',') ) {s = 29;}

                        else if ( (LA19_0=='.') ) {s = 30;}

                        else if ( (LA19_0=='(') ) {s = 31;}

                        else if ( (LA19_0==')') ) {s = 32;}

                        else if ( (LA19_0=='[') ) {s = 33;}

                        else if ( (LA19_0==']') ) {s = 34;}

                        else if ( (LA19_0=='{') ) {s = 35;}

                        else if ( (LA19_0=='}') ) {s = 36;}

                        else if ( ((LA19_0 >= 'A' && LA19_0 <= 'Z')||LA19_0=='_'||LA19_0=='d'||(LA19_0 >= 'g' && LA19_0 <= 'h')||(LA19_0 >= 'j' && LA19_0 <= 'k')||(LA19_0 >= 'p' && LA19_0 <= 'q')||LA19_0=='u'||(LA19_0 >= 'x' && LA19_0 <= 'z')) ) {s = 37;}

                        else if ( (LA19_0=='%') ) {s = 38;}

                        else if ( (LA19_0=='\r') ) {s = 39;}

                        else if ( (LA19_0=='\n') ) {s = 40;}

                        else if ( (LA19_0=='\t'||LA19_0==' ') ) {s = 41;}

                        else if ( (LA19_0=='\'') ) {s = 42;}

                        else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '\b')||(LA19_0 >= '\u000B' && LA19_0 <= '\f')||(LA19_0 >= '\u000E' && LA19_0 <= '\u001F')||(LA19_0 >= '#' && LA19_0 <= '$')||LA19_0=='&'||(LA19_0 >= '?' && LA19_0 <= '@')||LA19_0=='\\'||LA19_0=='^'||LA19_0=='`'||LA19_0=='|'||(LA19_0 >= '~' && LA19_0 <= '\uFFFF')) ) {s = 43;}

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA19_139 = input.LA(1);

                        s = -1;
                        if ( (LA19_139=='%') ) {s = 136;}

                        else if ( (LA19_139=='\r') ) {s = 137;}

                        else if ( (LA19_139=='\n') ) {s = 138;}

                        else if ( ((LA19_139 >= '\u0000' && LA19_139 <= '\t')||(LA19_139 >= '\u000B' && LA19_139 <= '\f')||(LA19_139 >= '\u000E' && LA19_139 <= '$')||(LA19_139 >= '&' && LA19_139 <= '\uFFFF')) ) {s = 139;}

                        else s = 112;

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA19_111 = input.LA(1);

                        s = -1;
                        if ( (LA19_111=='%') ) {s = 136;}

                        else if ( (LA19_111=='\r') ) {s = 137;}

                        else if ( (LA19_111=='\n') ) {s = 138;}

                        else if ( ((LA19_111 >= '\u0000' && LA19_111 <= '\t')||(LA19_111 >= '\u000B' && LA19_111 <= '\f')||(LA19_111 >= '\u000E' && LA19_111 <= '$')||(LA19_111 >= '&' && LA19_111 <= '\uFFFF')) ) {s = 139;}

                        else s = 112;

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA19_174 = input.LA(1);

                        s = -1;
                        if ( (LA19_174=='%') ) {s = 174;}

                        else if ( (LA19_174=='\r') ) {s = 137;}

                        else if ( (LA19_174=='\n') ) {s = 138;}

                        else if ( ((LA19_174 >= '\u0000' && LA19_174 <= '\t')||(LA19_174 >= '\u000B' && LA19_174 <= '\f')||(LA19_174 >= '\u000E' && LA19_174 <= '$')||(LA19_174 >= '&' && LA19_174 <= '\uFFFF')) ) {s = 139;}

                        else s = 161;

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA19_138 = input.LA(1);

                        s = -1;
                        if ( ((LA19_138 >= '\u0000' && LA19_138 <= '\uFFFF')) ) {s = 161;}

                        else s = 112;

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA19_18 = input.LA(1);

                        s = -1;
                        if ( ((LA19_18 >= '\u0000' && LA19_18 <= '\uFFFF')) ) {s = 71;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA19_137 = input.LA(1);

                        s = -1;
                        if ( ((LA19_137 >= '\u0000' && LA19_137 <= '\t')||(LA19_137 >= '\u000B' && LA19_137 <= '\uFFFF')) ) {s = 161;}

                        else if ( (LA19_137=='\n') ) {s = 138;}

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA19_160 = input.LA(1);

                        s = -1;
                        if ( (LA19_160=='%') ) {s = 174;}

                        else if ( (LA19_160=='\r') ) {s = 137;}

                        else if ( (LA19_160=='\n') ) {s = 138;}

                        else if ( ((LA19_160 >= '\u0000' && LA19_160 <= '\t')||(LA19_160 >= '\u000B' && LA19_160 <= '\f')||(LA19_160 >= '\u000E' && LA19_160 <= '$')||(LA19_160 >= '&' && LA19_160 <= '\uFFFF')) ) {s = 139;}

                        else s = 112;

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA19_136 = input.LA(1);

                        s = -1;
                        if ( (LA19_136=='%') ) {s = 160;}

                        else if ( (LA19_136=='\r') ) {s = 137;}

                        else if ( (LA19_136=='\n') ) {s = 138;}

                        else if ( ((LA19_136 >= '\u0000' && LA19_136 <= '\t')||(LA19_136 >= '\u000B' && LA19_136 <= '\f')||(LA19_136 >= '\u000E' && LA19_136 <= '$')||(LA19_136 >= '&' && LA19_136 <= '\uFFFF')) ) {s = 139;}

                        else s = 112;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}