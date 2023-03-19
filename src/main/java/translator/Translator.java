package translator;

import generated.GrammarBaseVisitor;
import generated.GrammarParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Translator extends GrammarBaseVisitor<StringBuilder> {

    @Override
    public StringBuilder visitStart(GrammarParser.StartContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (GrammarParser.LineContext context : ctx.line()) {
            sb.append(visitLine(context));
        }
        return sb;
    }

    @Override
    public StringBuilder visitLine(GrammarParser.LineContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (ctx.eq1() != null) {
            sb.append("<font color=\"pink\">").append(visitEq1(ctx.eq1())).append("</font>");
        } else if (ctx.eq2() != null) {
            sb.append("<font color=\"yellow;\">").append(visitEq2(ctx.eq2())).append("</font>");
        } else if (!ctx.text().isEmpty()) {
            for (GrammarParser.TextContext context : ctx.text()) {
                sb.append("<font color=\"green;\">").append(visitText(context)).append("</font>");
            }
        } else if (ctx.text_command() != null) {
            sb.append("<font color=\"blue;\">").append(visitText_command(ctx.text_command())).append("</font>");
        }
        return sb;
    }

    @Override
    public StringBuilder visitEq1(GrammarParser.Eq1Context ctx) {
        StringBuilder sb = new StringBuilder();
        if (!ctx.DOLLAR().isEmpty()) {
            sb.append(" ");
            for (GrammarParser.Math_commandContext context : ctx.math_command()) {
                sb.append(visitMath_command(context));
            }
            sb.append(" ");
        } else {
            //todo
        }
        return sb;
    }

    @Override
    public StringBuilder visitEq2(GrammarParser.Eq2Context ctx) {
        StringBuilder sb = new StringBuilder();
        if (!ctx.DOUBLE_DOLLAR().isEmpty()) {
            sb.append("<center>");
            for (GrammarParser.Math_commandContext context : ctx.math_command()) {
                sb.append(visitMath_command(context));
            }
            sb.append("</center>");
        } else {
            //todo
        }
        return sb;
    }

    @Override
    public StringBuilder visitMath_command(GrammarParser.Math_commandContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (!ctx.DIGIT().isEmpty()) {
            for (TerminalNode digit : ctx.DIGIT()) {
                sb.append(digit);
            }
        } else if (!ctx.CHARACTER().isEmpty()) {
            sb.append("<i>");
            for (TerminalNode character : ctx.CHARACTER()) {
                sb.append(character);
            }
            sb.append("</i>");
        } else if (!ctx.PUNCTUATION().isEmpty()) {
            sb.append("<i>");
            for (TerminalNode punctuation : ctx.PUNCTUATION()) {
                sb.append(punctuation);
            }
            sb.append("</i>");
        } else if (ctx.CARET() != null) {
            sb.append("<sup>").append(visitExpr(ctx.expr())).append("</sup>");
        } else {
            sb.append("<sub>").append(visitExpr(ctx.expr())).append("</sub>");
        }
        return sb;
    }

    @Override
    public StringBuilder visitExpr(GrammarParser.ExprContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (ctx.CHARACTER() != null) {
            sb.append("<i>").append(ctx.CHARACTER()).append("</i>");
        } else if (ctx.DIGIT() != null) {
            sb.append(ctx.DIGIT());
        } else if (ctx.LEFT_CURL() != null) {
            for (GrammarParser.Math_commandContext context : ctx.math_command()) {
                sb.append(visitMath_command(context));
            }
        }
        return sb;
    }

    @Override
    public StringBuilder visitText(GrammarParser.TextContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (!ctx.DIGIT().isEmpty()) {
            for (TerminalNode digit : ctx.DIGIT()) {
                sb.append(digit);
            }
//            sb.append(" ");
        } else if (!ctx.CHARACTER().isEmpty()) {
            for (TerminalNode character : ctx.CHARACTER()) {
                sb.append(character);
            }
//            sb.append(" ");
        } else if (!ctx.PUNCTUATION().isEmpty()) {
            for (TerminalNode punctuation : ctx.PUNCTUATION()) {
                sb.append(punctuation);
            }
//            sb.append(" ");
        } else {
            //todo
        }
        return sb;
    }

    private void addStylizedText(StringBuilder sb, String c, GrammarParser.Text_commandContext ctx) {
        sb.append("<").append(c).append(">");
        for (GrammarParser.TextContext context : ctx.text()) {
            sb.append(visitText(context));
        }
        sb.append("</").append(c).append(">");
    }

    @Override
    public StringBuilder visitText_command(GrammarParser.Text_commandContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (ctx.ITALICS() != null) {
            addStylizedText(sb, "i", ctx);
        } else if (ctx.BOLD() != null) {
            addStylizedText(sb, "b", ctx);
        } else if (ctx.MONOSPACE() != null) {
            addStylizedText(sb, "tt", ctx);
        } else {
            //todo
        }
        return sb;
    }
}
