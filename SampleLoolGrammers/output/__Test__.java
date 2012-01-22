import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import CompilerFiles.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        SampleLoolLexer lex = new SampleLoolLexer(new ANTLRFileStream("C:\\JavaProjects\\CompilerProject1390-11-1\\SampleLoolGrammers\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        SampleLoolParser g = new SampleLoolParser(tokens, 49100, null);
        try {
            g.file();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}