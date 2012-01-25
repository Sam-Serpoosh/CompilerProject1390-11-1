import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import com.jesus_mehdi.CompilerFiles.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        Lexer_ lex = new Lexer_(new ANTLRFileStream("C:\\JavaProjects\\CompilerProject1390-11-1\\CompilerFiles\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        Parser_ g = new Parser_(tokens, 49100, null);
        try {
            g.file();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}