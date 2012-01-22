// $ANTLR 3.4 C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g 2012-01-22 14:47:13

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SampleLoolLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ID=4;
    public static final int LETTER=5;
    public static final int LOWER=6;
    public static final int NEWLINE=7;
    public static final int TYPE_BOOL=8;
    public static final int TYPE_INT=9;
    public static final int UPPER=10;
    public static final int WHITESPACE=11;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public SampleLoolLexer() {} 
    public SampleLoolLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SampleLoolLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g"; }

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:3:11: ( ( ( '\\r' )? '\\n' )+ )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:3:13: ( ( '\\r' )? '\\n' )+
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:3:13: ( ( '\\r' )? '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\n'||LA2_0=='\r') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:3:14: ( '\\r' )? '\\n'
            	    {
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:3:14: ( '\\r' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='\r') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:3:14: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }


            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:4:13: ( ( ' ' | '\\t' )+ )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:4:16: ( ' ' | '\\t' )+
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:4:16: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:6:16: ( LOWER | UPPER )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:
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

    // $ANTLR start "TYPE_INT"
    public final void mTYPE_INT() throws RecognitionException {
        try {
            int _type = TYPE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:8:10: ( 'int' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:8:12: 'int'
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
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:9:11: ( 'bool' )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:9:13: 'bool'
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

    // $ANTLR start "LOWER"
    public final void mLOWER() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:11:16: ( ( 'a' .. 'z' ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:
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
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:12:16: ( ( 'A' .. 'Z' ) )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:14:8: ( ( LETTER | '_' ) ( LETTER | '_' )* )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:14:10: ( LETTER | '_' ) ( LETTER | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:14:25: ( LETTER | '_' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    public void mTokens() throws RecognitionException {
        // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:1:8: ( NEWLINE | WHITESPACE | TYPE_INT | TYPE_BOOL | ID )
        int alt5=5;
        switch ( input.LA(1) ) {
        case '\n':
        case '\r':
            {
            alt5=1;
            }
            break;
        case '\t':
        case ' ':
            {
            alt5=2;
            }
            break;
        case 'i':
            {
            int LA5_3 = input.LA(2);

            if ( (LA5_3=='n') ) {
                int LA5_6 = input.LA(3);

                if ( (LA5_6=='t') ) {
                    int LA5_8 = input.LA(4);

                    if ( ((LA5_8 >= 'A' && LA5_8 <= 'Z')||LA5_8=='_'||(LA5_8 >= 'a' && LA5_8 <= 'z')) ) {
                        alt5=5;
                    }
                    else {
                        alt5=3;
                    }
                }
                else {
                    alt5=5;
                }
            }
            else {
                alt5=5;
            }
            }
            break;
        case 'b':
            {
            int LA5_4 = input.LA(2);

            if ( (LA5_4=='o') ) {
                int LA5_7 = input.LA(3);

                if ( (LA5_7=='o') ) {
                    int LA5_9 = input.LA(4);

                    if ( (LA5_9=='l') ) {
                        int LA5_11 = input.LA(5);

                        if ( ((LA5_11 >= 'A' && LA5_11 <= 'Z')||LA5_11=='_'||(LA5_11 >= 'a' && LA5_11 <= 'z')) ) {
                            alt5=5;
                        }
                        else {
                            alt5=4;
                        }
                    }
                    else {
                        alt5=5;
                    }
                }
                else {
                    alt5=5;
                }
            }
            else {
                alt5=5;
            }
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=5;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:1:10: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 2 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:1:18: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 3 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:1:29: TYPE_INT
                {
                mTYPE_INT(); 


                }
                break;
            case 4 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:1:38: TYPE_BOOL
                {
                mTYPE_BOOL(); 


                }
                break;
            case 5 :
                // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolLexer.g:1:48: ID
                {
                mID(); 


                }
                break;

        }

    }


 

}