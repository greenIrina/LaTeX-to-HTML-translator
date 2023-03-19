package translator;

import generated.GrammarLexer;
import generated.GrammarParser;
import generated.GrammarVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(
                "Finally $A^2$ \\textit{is} $$A^2 = b_1 - c_3^2$$"));
        TokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        GrammarVisitor<StringBuilder> v = new Translator();
        final StringBuilder text = v.visitStart(parser.start());
//        System.out.println(text);
        try (FileWriter fileWriter = new FileWriter("gen.html")) {
            fileWriter.write(text.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}