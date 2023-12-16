package nl.parser;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.strings.TruffleString;
import nl.node.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NlParser extends NLLangBaseVisitor<Node> {

    public static void main(String[] args) {
        Source nl = Source.newBuilder("nl",new StringBuffer("(id=>(2*1+2+7)*3/122*22)(a)"),"nl").build();
        Node node = parseNL(null,nl);
        System.out.println(node);
    }


    private final TruffleLanguage<?> language;

    public NlParser(TruffleLanguage<?> language) {
        this.language = language;
    }

    public static Node parseNL(TruffleLanguage<?> language,Source source) {
        String string = source.getCharacters().toString();
        NLLangLexer lexer = new NLLangLexer(CharStreams.fromString(string));
        NLLangParser parser = new NLLangParser(new CommonTokenStream(lexer));
        NlParser nlParser = new NlParser(language);
        return nlParser.visit(parser.nllang());
    }


    @Override
    public Node visitCall(NLLangParser.CallContext ctx) {
        Node callTarget = visit(ctx.expression());
        NLLangParser.CallInputsContext callInputsContext = ctx.callInputs();

        List<NLLangParser.NllangContext> expressionList = callInputsContext.nllang();
        Node[] nodes = new Node[expressionList.size()];

        for (int i = 0; i < expressionList.size(); i++) {
            NLLangParser.NllangContext expressionContext = expressionList.get(i);
            nodes[i]= visit(expressionContext);
        }

        return new CallExpression(language,callTarget,nodes);
    }

    static class LexicalScope {
        protected final LexicalScope outer;
        protected final Map<TruffleString, Integer> locals;

        LexicalScope(LexicalScope outer) {
            this.outer = outer;
            this.locals = new HashMap<>();
        }

        public Integer find(TruffleString name) {
            Integer result = locals.get(name);
            if (result != null) {
                return result;
            } else if (outer != null) {
                return outer.find(name);
            } else {
                return null;
            }
        }
    }
    private LexicalScope lexicalScope;
    public void startBlock() {
        lexicalScope = new LexicalScope(lexicalScope);
    }

    public void finishBlock(){
        lexicalScope = lexicalScope.outer;
    }

    @Override
    public Node visitFunction(NLLangParser.FunctionContext ctx) {
        startBlock();
        List<WriteVarExpression> writeVarExpressions = new ArrayList<>();
        List<NLLangParser.IdContext> ids = ctx.id();
//        List<IdExpression> idExpressions = new ArrayList<>();
        FrameDescriptor.Builder builder = FrameDescriptor.newBuilder();
        for (int i = 0; i < ids.size(); i++) {
            NLLangParser.IdContext idContext = ids.get(i);
            IdExpression id = (IdExpression) visitInputArgs(idContext);
            id.setPos(i);
//            idExpressions.add(id);
            lexicalScope.locals.put(id.getId(),i);
            WriteVarExpression writeVarExpression = WriteVarExpressionNodeGen.create(language, new ReadArgumentExpression(language, i), i);
            writeVarExpressions.add(writeVarExpression);
            builder.addSlot(FrameSlotKind.Illegal, id.getId(), i);
        }

        Node bodyRes = null;
        NLLangParser.ExpressionContext exp = ctx.expression();
        NLLangParser.CallContext call = ctx.call();
        if(exp != null){
            bodyRes =  visit(exp);
        } else if(call!=null){
            bodyRes =  visit(call);
        }
        finishBlock();
        return new FunctionExpression(language
//                ,idExpressions
                , new FunctionBodyExpression(language,builder.build(),writeVarExpressions, bodyRes));
    }
    public Node visitInputArgs(NLLangParser.IdContext ctx) {
        return new IdExpression(language,TruffleString.fromConstant(ctx.start.getText(), TruffleString.Encoding.UTF_8),0);
    }

    @Override
    public Node visitStr(NLLangParser.StrContext ctx) {
        return new StringExpression(language,TruffleString.fromConstant(ctx.start.getText(), TruffleString.Encoding.UTF_8));
    }

    @Override
    public Node visitId(NLLangParser.IdContext ctx) {
        TruffleString id = TruffleString.fromConstant(ctx.start.getText(), TruffleString.Encoding.UTF_8);
        Integer index = lexicalScope.find(id);
        return new IdExpression(language, id,index);
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
            case "*" -> MulExpressionNodeGen.create(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            case "/" -> DevExpressionNodeGen.create(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            default -> super.visitMulDiv(ctx);
        };
    }

    @Override
    public Node visitAddSub(NLLangParser.AddSubContext ctx) {
        return switch (ctx.op.getText()) {
            case "+" -> AddExpressionNodeGen.create(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            case "-" -> SubExpressionNodeGen.create(language, visit(ctx.expression(0)), visit(ctx.expression(1)));
            default -> super.visitAddSub(ctx);
        };
    }
}
