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
	 * Enter a parse tree produced by the {@code comp}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComp(NLLangParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comp}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComp(NLLangParser.CompContext ctx);
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
	 * Enter a parse tree produced by the {@code as}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAs(NLLangParser.AsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code as}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAs(NLLangParser.AsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code c}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterC(NLLangParser.CContext ctx);
	/**
	 * Exit a parse tree produced by the {@code c}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitC(NLLangParser.CContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBool(NLLangParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link NLLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBool(NLLangParser.BoolContext ctx);
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
	 * Enter a parse tree produced by {@link NLLangParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(NLLangParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(NLLangParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(NLLangParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(NLLangParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(NLLangParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(NLLangParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#break}.
	 * @param ctx the parse tree
	 */
	void enterBreak(NLLangParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#break}.
	 * @param ctx the parse tree
	 */
	void exitBreak(NLLangParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#continue}.
	 * @param ctx the parse tree
	 */
	void enterContinue(NLLangParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#continue}.
	 * @param ctx the parse tree
	 */
	void exitContinue(NLLangParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(NLLangParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(NLLangParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(NLLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(NLLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(NLLangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(NLLangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(NLLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(NLLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(NLLangParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(NLLangParser.BooleanContext ctx);
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
	 * Enter a parse tree produced by {@link NLLangParser#callValue}.
	 * @param ctx the parse tree
	 */
	void enterCallValue(NLLangParser.CallValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#callValue}.
	 * @param ctx the parse tree
	 */
	void exitCallValue(NLLangParser.CallValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NLLangParser#callInput}.
	 * @param ctx the parse tree
	 */
	void enterCallInput(NLLangParser.CallInputContext ctx);
	/**
	 * Exit a parse tree produced by {@link NLLangParser#callInput}.
	 * @param ctx the parse tree
	 */
	void exitCallInput(NLLangParser.CallInputContext ctx);
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