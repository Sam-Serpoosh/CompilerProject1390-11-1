// $ANTLR 3.4 C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g 2012-01-22 14:47:21
package CompilerFiles;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SampleLoolParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "LETTER", "LOWER", "NEWLINE", "TYPE_BOOL", "TYPE_INT", "UPPER", "WHITESPACE"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public SampleLoolParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public SampleLoolParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SampleLoolParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g"; }



    // $ANTLR start "file"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:11:1: file : program EOF ;
    public final void file() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:11:7: ( program EOF )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:11:10: program EOF
            {
            pushFollow(FOLLOW_program_in_file36);
            program();

            state._fsp--;


            match(input,EOF,FOLLOW_EOF_in_file38); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "file"



    // $ANTLR start "program"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:1: program : ( decl )+ ;
    public final void program() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:9: ( ( decl )+ )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:11: ( decl )+
            {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:11: ( decl )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= TYPE_BOOL && LA1_0 <= TYPE_INT)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:12: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_program46);
            	    decl();

            	    state._fsp--;


            	    Fuck.fuckYou();

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "type"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:13:1: type : ( TYPE_INT | TYPE_BOOL );
    public final void type() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:13:7: ( TYPE_INT | TYPE_BOOL )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:
            {
            if ( (input.LA(1) >= TYPE_BOOL && input.LA(1) <= TYPE_INT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "id"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:14:1: id : ID ;
    public final void id() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:14:4: ( ID )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:14:6: ID
            {
            match(input,ID,FOLLOW_ID_in_id69); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "id"



    // $ANTLR start "decl"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:15:1: decl : type id ;
    public final void decl() throws RecognitionException {
        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:15:6: ( type id )
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:15:9: type id
            {
            pushFollow(FOLLOW_type_in_decl77);
            type();

            state._fsp--;


            pushFollow(FOLLOW_id_in_decl79);
            id();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "decl"

    // Delegated rules


 

    public static final BitSet FOLLOW_program_in_file36 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_file38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_in_program46 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_ID_in_id69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_decl77 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_id_in_decl79 = new BitSet(new long[]{0x0000000000000002L});

}