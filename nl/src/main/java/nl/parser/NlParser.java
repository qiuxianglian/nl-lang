package nl.parser;


import nl.node.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NlParser extends NLLangBaseVisitor<Node> {

    public static void main(String[] args) {
//        Source nl = Source.newBuilder("nl",new StringBuffer("1+2"),"nl").build();
//        Node node = parseNL(null,nl);
//        AddExpression addExpression = AddExpressionNodeGen.create(null,
//                new NumberExpression(null, 1), new NumberExpression(null, 2));
//
//        Object add = add(addExpression);
//
//
//        Node node2 = parseNL(null, Source.newBuilder("nl"
//                , new StringBuffer("1 + 2 * 5"), "nl").build());
//
//        Node 你好 = parseNL(null,Source.newBuilder("nl",new StringBuffer("12 + (你好=>你好)(1)"),"nl").build());
//
//        System.out.println(add);
    }


    @Override
    public Node visitNllang(NLLangParser.NllangContext ctx) {
        NLLangParser.StatementsContext statements = ctx.statements();
        if(statements!=null){
            return new RootEnter(language,visit(statements));
        }
        NLLangParser.ExpressionContext expression = ctx.expression();
        if(expression!=null){
            return new RootEnter(language,visit(expression));
        }
        return super.visitNllang(ctx);
    }

    @Override
    public Node visitStatements(NLLangParser.StatementsContext ctx) {
        List<Node> statements = new ArrayList<>();
        List<NLLangParser.StatementContext> statement = ctx.statement();
        for (NLLangParser.StatementContext statementContext : statement) {
            statements.add(visit(statementContext));
        }
        NLLangParser.ExpressionContext expression = ctx.expression();
        if(expression!=null){
            Node exp = visit(expression);
            statements.add(exp);
        }
        return new Statements(language,statements);
    }

    @Override
    public Node visitStatement(NLLangParser.StatementContext ctx) {
        return new Statement(language,visit(ctx.expression()));
    }

    @Override
    public Node visitAssign(NLLangParser.AssignContext ctx) {
        return new AssignExpression(language, (IdExpression) visitId(ctx.id()),visit(ctx.expression()));
    }

    @Override
    public Node visitBoolean(NLLangParser.BooleanContext ctx) {
        return new BooleanExpression(language,Boolean.parseBoolean(ctx.start.getText()));
    }

    private static Object add(AddExpression addExpression){
        return ((NumberExpression)addExpression.getLeft().execute(null)).getNum().longValue()
                +((NumberExpression)addExpression.getRight().execute(null)).getNum().longValue();
    }


    private final Lang language;

    public NlParser(Lang language) {
        this.language = language;
    }

    public static Node parseNL(Lang language, InputStreamReader source) throws IOException {
        CodePointCharStream codePointCharStream = CharStreams.fromReader(source);
        NLLangLexer lexer = new NLLangLexer(codePointCharStream);
        NLLangParser parser = new NLLangParser(new CommonTokenStream(lexer));
        NlParser nlParser = new NlParser(language);
        return nlParser.visit(parser.nllang());
    }

    @Override
    public Node visitCallValue(NLLangParser.CallValueContext ctx) {
        NLLangParser.IdContext id = ctx.id();
        if(id!=null){
            return visit(id);
        }
        NLLangParser.FunctionContext function = ctx.function();
        if(function!=null){
            return visit(function);
        }

        return super.visitCallValue(ctx);
    }

    @Override
    public Node visitCall(NLLangParser.CallContext ctx) {
        NLLangParser.CallValueContext callValueContext = ctx.callValue();
        Node callTarget = visit(callValueContext);
        List<NLLangParser.CallInputContext> callInputContexts = ctx.callInput();
        Node callExpression = null;
        for (NLLangParser.CallInputContext callInputContext : callInputContexts) {
            List<NLLangParser.ExpressionContext> expressionList = callInputContext.expression();
            Node[] nodes = new Node[expressionList.size()];

            for (int i = 0; i < expressionList.size(); i++) {
                NLLangParser.ExpressionContext expressionContext = expressionList.get(i);
                nodes[i] = visit(expressionContext);
            }
            if (callExpression == null) {
                callExpression = new CallExpression(language, callTarget, nodes);
            } else {
                callExpression = new CallExpression(language, callExpression, nodes);
            }
        }
        return callExpression;
    }


    @Override
    public Node visitFunction(NLLangParser.FunctionContext ctx) {

        NLLangParser.FunctionContext function = ctx.function();
        if(function!=null){
            return visit(function);
        }
        List<NLLangParser.IdContext> ids = ctx.id();
        List<IdExpression> idExpressions = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            NLLangParser.IdContext idContext = ids.get(i);
            IdExpression id = (IdExpression) visit(idContext);
            idExpressions.add(id);
        }

        Node bodyRes = null;
        NLLangParser.ExpressionContext exp = ctx.expression();
        NLLangParser.CallContext call = ctx.call();
        if(exp != null){
            bodyRes =  visit(exp);
        } else if(call!=null){
            bodyRes =  visit(call);
        }
        return new FunctionExpression(language
                ,idExpressions
                ,bodyRes
        );
    }

    @Override
    public Node visitStr(NLLangParser.StrContext ctx) {
        return new StringExpression(language, ctx.start.getText());
    }

    @Override
    public Node visitId(NLLangParser.IdContext ctx) {
        String id = ctx.start.getText();
        return new IdExpression(language, id);
    }

    @Override
    public Node visitDecimal(NLLangParser.DecimalContext ctx) {
        return new NumberExpression(language,Double.parseDouble(ctx.start.getText()));
    }

    @Override
    public Node visitInt(NLLangParser.IntContext ctx) {
        return new NumberExpression(language,Long.parseLong(ctx.start.getText()));
    }

    @Override
    public Node visitParens(NLLangParser.ParensContext ctx) {
        NLLangParser.ExpressionContext expression = ctx.expression();
        return visit(expression);
    }

    @Override
    public Node visitMulDiv(NLLangParser.MulDivContext ctx) {
        return switch (ctx.op.getText()) {
            case "*" -> new MulExpression(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            case "/" -> new DevExpression(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            default -> super.visitMulDiv(ctx);
        };
    }

    @Override
    public Node visitAddSub(NLLangParser.AddSubContext ctx) {
        return switch (ctx.op.getText()) {
            case "+" -> new AddExpression(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            case "-" -> new SubExpression(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            default -> super.visitAddSub(ctx);
        };
    }
}
