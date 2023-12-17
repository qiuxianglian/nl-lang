// Generated from /home/dog/work/java/nl/nl/src/main/java/nl/parser/NLLang.g4 by ANTLR 4.12.0
package nl.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NLLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NLLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NLLangParser#nllang}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNllang(NLLangParser.NllangContext ctx);
	/**
	 * Visit a parse tree produced by the {@code str}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(NLLangParser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(NLLangParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code c}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(NLLangParser.CContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(NLLangParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(NLLangParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(NLLangParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fn}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn(NLLangParser.FnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code theid}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTheid(NLLangParser.TheidContext ctx);
	/**
	 * Visit a parse tree produced by {@link NLLangParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(NLLangParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link NLLangParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(NLLangParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NLLangParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(NLLangParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link NLLangParser#callValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallValue(NLLangParser.CallValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link NLLangParser#callInput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallInput(NLLangParser.CallInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link NLLangParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(NLLangParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link NLLangParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(NLLangParser.DecimalContext ctx);
}