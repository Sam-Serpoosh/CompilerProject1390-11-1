// $ANTLR 3.4 C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g 2012-01-25 11:31:10
package CompilerFiles;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class SampleLoolParser extends DebugParser {
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


public static final String[] ruleNames = new String[] {
    "invalidRule", "decl", "file", "type", "program", "id"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public SampleLoolParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public SampleLoolParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public SampleLoolParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return SampleLoolParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g"; }



    // $ANTLR start "file"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:11:1: file : program EOF ;
    public final void file() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "file");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(11, 0);

        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:11:7: ( program EOF )
            dbg.enterAlt(1);

            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:11:10: program EOF
            {
            dbg.location(11,10);
            pushFollow(FOLLOW_program_in_file36);
            program();

            state._fsp--;

            dbg.location(11,18);
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
        dbg.location(11, 20);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "file");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "file"



    // $ANTLR start "program"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:1: program : ( decl )+ ;
    public final void program() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "program");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(12, 0);

        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:9: ( ( decl )+ )
            dbg.enterAlt(1);

            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:11: ( decl )+
            {
            dbg.location(12,11);
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:11: ( decl )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= TYPE_BOOL && LA1_0 <= TYPE_INT)) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:12:12: decl
            	    {
            	    dbg.location(12,12);
            	    pushFollow(FOLLOW_decl_in_program46);
            	    decl();

            	    state._fsp--;

            	    dbg.location(12,16);
            	    System.out.println("Kosse Nanant Ramak");

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(12, 60);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "program");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "type"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:13:1: type : ( TYPE_INT | TYPE_BOOL );
    public final void type() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(13, 0);

        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:13:7: ( TYPE_INT | TYPE_BOOL )
            dbg.enterAlt(1);

            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:
            {
            dbg.location(13,7);
            if ( (input.LA(1) >= TYPE_BOOL && input.LA(1) <= TYPE_INT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(13, 29);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "id"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:14:1: id : ID ;
    public final void id() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "id");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(14, 0);

        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:14:4: ( ID )
            dbg.enterAlt(1);

            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:14:6: ID
            {
            dbg.location(14,6);
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
        dbg.location(14, 7);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "id");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "id"



    // $ANTLR start "decl"
    // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:15:1: decl : type id ;
    public final void decl() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(15, 0);

        try {
            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:15:6: ( type id )
            dbg.enterAlt(1);

            // C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\SampleLoolParser.g:15:9: type id
            {
            dbg.location(15,9);
            pushFollow(FOLLOW_type_in_decl77);
            type();

            state._fsp--;

            dbg.location(15,14);
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
        dbg.location(15, 15);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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