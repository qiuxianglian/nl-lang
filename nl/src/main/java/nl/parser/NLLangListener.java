// Generated from /home/dog/work/java/nl/nl/src/main/java/nl/parser/NLLang.g4 by ANTLR 4.12.0
package nl.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NLLangParser}.
 */
public interface NLLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NLLangParser#nllang}.
	 * @param ctx the parse tree
	 */
	void enterNllang(NLLangParser.NllangContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#nllang}.
	 * @param ctx the parse tree
	 */
	void exitNllang(NLLangParser.NllangContext ctx);
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStr(NLLangParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStr(NLLangParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParens(NLLangParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParens(NLLangParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(NLLangParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(NLLangParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(NLLangParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(NLLangParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNum(NLLangParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNum(NLLangParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fn}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFn(NLLangParser.FnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fn}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFn(NLLangParser.FnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code theid}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTheid(NLLangParser.TheidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code theid}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTheid(NLLangParser.TheidContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(NLLangParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(NLLangParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(NLLangParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(NLLangParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(NLLangParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(NLLangParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#callInputs}.
	 * @param ctx the parse tree
	 */
	void enterCallInputs(NLLangParser.CallInputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#callInputs}.
	 * @param ctx the parse tree
	 */
	void exitCallInputs(NLLangParser.CallInputsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link NLLangParser#number}.
	 * @param ctx the parse tree
	 */
	void enterInt(NLLangParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link NLLangParser#number}.
	 * @param ctx the parse tree
	 */
	void exitInt(NLLangParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link NLLangParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(NLLangParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link NLLangParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(NLLangParser.DecimalContext ctx);
}