// Generated from /home/dog/work/java/nl/nl/src/main/java/nl/parser/NLLang.g4 by ANTLR 4.12.0
package nl.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NLLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, WS=11, COMMENT=12, LINE_COMMENT=13, Identifier=14, IDENTIFIER=15, 
		STRING_LITERAL=16, INT=17, Decimal=18, FN_SP=19, TRUE=20, FALSE=21;
	public static final int
		RULE_nllang = 0, RULE_expression = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_assign = 4, RULE_boolean = 5, RULE_id = 6, RULE_function = 7, RULE_call = 8, 
		RULE_callValue = 9, RULE_callInput = 10, RULE_number = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"nllang", "expression", "statements", "statement", "assign", "boolean", 
			"id", "function", "call", "callValue", "callInput", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'('", "')'", "';'", "':'", "'='", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "WS", 
			"COMMENT", "LINE_COMMENT", "Identifier", "IDENTIFIER", "STRING_LITERAL", 
			"INT", "Decimal", "FN_SP", "TRUE", "FALSE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NLLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NLLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NllangContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NllangContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nllang; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterNllang(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitNllang(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitNllang(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NllangContext nllang() throws RecognitionException {
		NllangContext _localctx = new NllangContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_nllang);
		try {
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				statements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StrContext extends ExpressionContext {
		public TerminalNode STRING_LITERAL() { return getToken(NLLangParser.STRING_LITERAL, 0); }
		public StrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParensContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsContext extends ExpressionContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public AsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitAs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitAs(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CContext extends ExpressionContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public CContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitC(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExpressionContext {
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public BoolContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MulDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FnContext extends ExpressionContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FnContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitFn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TheidContext extends ExpressionContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TheidContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterTheid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitTheid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitTheid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(29);
				number();
				}
				break;
			case 2:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(T__4);
				setState(31);
				expression(0);
				setState(32);
				match(T__5);
				}
				break;
			case 3:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(STRING_LITERAL);
				}
				break;
			case 4:
				{
				_localctx = new FnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				function();
				}
				break;
			case 5:
				{
				_localctx = new TheidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				id();
				}
				break;
			case 6:
				{
				_localctx = new CContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				call();
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				boolean_();
				}
				break;
			case 8:
				{
				_localctx = new AsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				assign();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(48);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(42);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(43);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(44);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(45);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(46);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(47);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			statement();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3621024L) != 0)) {
				{
				{
				setState(54);
				statement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3620896L) != 0)) {
				{
				setState(60);
				expression(0);
				}
			}

			setState(63);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			id();
			setState(66);
			match(T__7);
			setState(67);
			match(T__8);
			setState(68);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(NLLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NLLangParser.FALSE, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(NLLangParser.Identifier, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode FN_SP() { return getToken(NLLangParser.FN_SP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				id();
				setState(75);
				match(FN_SP);
				setState(78);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(76);
					expression(0);
					}
					break;
				case 2:
					{
					setState(77);
					call();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(T__4);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(81);
					id();
					}
				}

				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(84);
					match(T__9);
					setState(85);
					id();
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
				match(T__5);
				setState(92);
				match(FN_SP);
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(93);
					expression(0);
					}
					break;
				case 2:
					{
					setState(94);
					call();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(T__4);
				setState(98);
				function();
				setState(99);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public CallValueContext callValue() {
			return getRuleContext(CallValueContext.class,0);
		}
		public List<CallInputContext> callInput() {
			return getRuleContexts(CallInputContext.class);
		}
		public CallInputContext callInput(int i) {
			return getRuleContext(CallInputContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_call);
		int _la;
		try {
			int _alt;
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				callValue();
				setState(104);
				callInput();
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(105);
						callInput();
						}
						} 
					}
					setState(110);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__4);
				setState(112);
				callValue();
				setState(113);
				callInput();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(114);
					callInput();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallValueContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public CallValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterCallValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitCallValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitCallValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallValueContext callValue() throws RecognitionException {
		CallValueContext _localctx = new CallValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_callValue);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(T__4);
				setState(126);
				function();
				setState(127);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(T__4);
				setState(130);
				id();
				setState(131);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallInputContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CallInputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callInput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterCallInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitCallInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitCallInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallInputContext callInput() throws RecognitionException {
		CallInputContext _localctx = new CallInputContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_callInput);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__4);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3620896L) != 0)) {
				{
				setState(136);
				expression(0);
				}
			}

			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(139);
				match(T__9);
				setState(140);
				expression(0);
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalContext extends NumberContext {
		public TerminalNode Decimal() { return getToken(NLLangParser.Decimal, 0); }
		public DecimalContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends NumberContext {
		public TerminalNode INT() { return getToken(NLLangParser.INT, 0); }
		public IntContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NLLangListener ) ((NLLangListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NLLangVisitor ) return ((NLLangVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_number);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(INT);
				}
				break;
			case Decimal:
				_localctx = new DecimalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(Decimal);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015\u0099\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0003\u0000\u001b\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001)\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00011\b\u0001\n\u0001\f\u00014\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0005\u00028\b\u0002\n\u0002\f\u0002;\t\u0002\u0001\u0003\u0003\u0003"+
		">\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007O\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007S\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007W\b\u0007\n\u0007\f\u0007Z\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007`\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007f\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0005\bk\b\b\n\b\f\bn\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bt\b"+
		"\b\n\b\f\bw\t\b\u0001\b\u0001\b\u0003\b{\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0086\b\t\u0001\n\u0001"+
		"\n\u0003\n\u008a\b\n\u0001\n\u0001\n\u0005\n\u008e\b\n\n\n\f\n\u0091\t"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000b\u0097\b\u000b\u0001"+
		"\u000b\u0000\u0001\u0002\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0000\u0003\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004"+
		"\u0001\u0000\u0014\u0015\u00a6\u0000\u001a\u0001\u0000\u0000\u0000\u0002"+
		"(\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u0006=\u0001"+
		"\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000\nF\u0001\u0000\u0000\u0000"+
		"\fH\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000\u0000\u0010z\u0001"+
		"\u0000\u0000\u0000\u0012\u0085\u0001\u0000\u0000\u0000\u0014\u0087\u0001"+
		"\u0000\u0000\u0000\u0016\u0096\u0001\u0000\u0000\u0000\u0018\u001b\u0003"+
		"\u0004\u0002\u0000\u0019\u001b\u0003\u0002\u0001\u0000\u001a\u0018\u0001"+
		"\u0000\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u0001\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0006\u0001\uffff\uffff\u0000\u001d)\u0003"+
		"\u0016\u000b\u0000\u001e\u001f\u0005\u0005\u0000\u0000\u001f \u0003\u0002"+
		"\u0001\u0000 !\u0005\u0006\u0000\u0000!)\u0001\u0000\u0000\u0000\")\u0005"+
		"\u0010\u0000\u0000#)\u0003\u000e\u0007\u0000$)\u0003\f\u0006\u0000%)\u0003"+
		"\u0010\b\u0000&)\u0003\n\u0005\u0000\')\u0003\b\u0004\u0000(\u001c\u0001"+
		"\u0000\u0000\u0000(\u001e\u0001\u0000\u0000\u0000(\"\u0001\u0000\u0000"+
		"\u0000(#\u0001\u0000\u0000\u0000($\u0001\u0000\u0000\u0000(%\u0001\u0000"+
		"\u0000\u0000(&\u0001\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000)2\u0001"+
		"\u0000\u0000\u0000*+\n\n\u0000\u0000+,\u0007\u0000\u0000\u0000,1\u0003"+
		"\u0002\u0001\u000b-.\n\t\u0000\u0000./\u0007\u0001\u0000\u0000/1\u0003"+
		"\u0002\u0001\n0*\u0001\u0000\u0000\u00000-\u0001\u0000\u0000\u000014\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"3\u0003\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000059\u0003\u0006"+
		"\u0003\u000068\u0003\u0006\u0003\u000076\u0001\u0000\u0000\u00008;\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":\u0005\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<>\u0003\u0002"+
		"\u0001\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0005\u0007\u0000\u0000@\u0007\u0001\u0000\u0000"+
		"\u0000AB\u0003\f\u0006\u0000BC\u0005\b\u0000\u0000CD\u0005\t\u0000\u0000"+
		"DE\u0003\u0002\u0001\u0000E\t\u0001\u0000\u0000\u0000FG\u0007\u0002\u0000"+
		"\u0000G\u000b\u0001\u0000\u0000\u0000HI\u0005\u000e\u0000\u0000I\r\u0001"+
		"\u0000\u0000\u0000JK\u0003\f\u0006\u0000KN\u0005\u0013\u0000\u0000LO\u0003"+
		"\u0002\u0001\u0000MO\u0003\u0010\b\u0000NL\u0001\u0000\u0000\u0000NM\u0001"+
		"\u0000\u0000\u0000Of\u0001\u0000\u0000\u0000PR\u0005\u0005\u0000\u0000"+
		"QS\u0003\f\u0006\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"SX\u0001\u0000\u0000\u0000TU\u0005\n\u0000\u0000UW\u0003\f\u0006\u0000"+
		"VT\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000[\\\u0005\u0006\u0000\u0000\\_\u0005\u0013\u0000\u0000]`\u0003"+
		"\u0002\u0001\u0000^`\u0003\u0010\b\u0000_]\u0001\u0000\u0000\u0000_^\u0001"+
		"\u0000\u0000\u0000`f\u0001\u0000\u0000\u0000ab\u0005\u0005\u0000\u0000"+
		"bc\u0003\u000e\u0007\u0000cd\u0005\u0006\u0000\u0000df\u0001\u0000\u0000"+
		"\u0000eJ\u0001\u0000\u0000\u0000eP\u0001\u0000\u0000\u0000ea\u0001\u0000"+
		"\u0000\u0000f\u000f\u0001\u0000\u0000\u0000gh\u0003\u0012\t\u0000hl\u0003"+
		"\u0014\n\u0000ik\u0003\u0014\n\u0000ji\u0001\u0000\u0000\u0000kn\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"m{\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\u0005\u0000"+
		"\u0000pq\u0003\u0012\t\u0000qu\u0003\u0014\n\u0000rt\u0003\u0014\n\u0000"+
		"sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000xy\u0005\u0006\u0000\u0000y{\u0001\u0000\u0000\u0000zg\u0001"+
		"\u0000\u0000\u0000zo\u0001\u0000\u0000\u0000{\u0011\u0001\u0000\u0000"+
		"\u0000|\u0086\u0003\f\u0006\u0000}~\u0005\u0005\u0000\u0000~\u007f\u0003"+
		"\u000e\u0007\u0000\u007f\u0080\u0005\u0006\u0000\u0000\u0080\u0086\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0005\u0005\u0000\u0000\u0082\u0083\u0003"+
		"\f\u0006\u0000\u0083\u0084\u0005\u0006\u0000\u0000\u0084\u0086\u0001\u0000"+
		"\u0000\u0000\u0085|\u0001\u0000\u0000\u0000\u0085}\u0001\u0000\u0000\u0000"+
		"\u0085\u0081\u0001\u0000\u0000\u0000\u0086\u0013\u0001\u0000\u0000\u0000"+
		"\u0087\u0089\u0005\u0005\u0000\u0000\u0088\u008a\u0003\u0002\u0001\u0000"+
		"\u0089\u0088\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u008f\u0001\u0000\u0000\u0000\u008b\u008c\u0005\n\u0000\u0000\u008c"+
		"\u008e\u0003\u0002\u0001\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0006\u0000\u0000\u0093"+
		"\u0015\u0001\u0000\u0000\u0000\u0094\u0097\u0005\u0011\u0000\u0000\u0095"+
		"\u0097\u0005\u0012\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096"+
		"\u0095\u0001\u0000\u0000\u0000\u0097\u0017\u0001\u0000\u0000\u0000\u0012"+
		"\u001a(029=NRX_eluz\u0085\u0089\u008f\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}