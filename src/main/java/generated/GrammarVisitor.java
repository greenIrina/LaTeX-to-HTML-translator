// Generated from java-escape by ANTLR 4.11.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(GrammarParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#eq1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq1(GrammarParser.Eq1Context ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#eq2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq2(GrammarParser.Eq2Context ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#math_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_command(GrammarParser.Math_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#text_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_command(GrammarParser.Text_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(GrammarParser.TextContext ctx);
}