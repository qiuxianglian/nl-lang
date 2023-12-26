package nl.node;

import nl.NLException;

import java.util.List;

public interface Visitor<T> {

     default  T accept(Node node){
        if(node == null){
            return null;
        }
        return node.accept(this);
    }

    default T accept(List<? extends Node> nodeList){
        T res = null;
        for (Node node : nodeList) {
            if(node!=null){
                if(res==null){
                    res = node.accept(this);
                }else{
                    res= aggResult(res, node.accept(this));
                }
            }
        }
        return res;
    }
    default T accept(Node ... nodes){
         T res = null;
        for (Node node : nodes) {
            if(node!=null){
                if(res==null){
                    res = node.accept(this);
                }else{
                   res= aggResult(res, node.accept(this));
                }
            }
        }
        return res;
    }

    default T aggResult(T t1,T t2){
        return t2;
    }


    default T visit(Node node) {
        if (node == null) return null;
        if (node instanceof AddExpression nnode) return visitAddExpression(nnode);
        if (node instanceof ArrayNode nnode) return visitArrayNode(nnode);
        if (node instanceof AssignExpression nnode) return visitAssignExpression(nnode);
        if (node instanceof BlockNode nnode) return visitBlockNode(nnode);
        if (node instanceof BooleanExpression nnode) return visitBooleanExpression(nnode);
        if (node instanceof BreakNode nnode) return visitBreakNode(nnode);
        if (node instanceof CallExpression nnode) return visitCallExpression(nnode);
        if (node instanceof ContinueNode nnode) return visitContinueNode(nnode);
        if (node instanceof DevExpression nnode) return visitDevExpression(nnode);
        if (node instanceof EuqalExpression nnode) return visitEuqalExpression(nnode);
        if (node instanceof FunctionExpression nnode) return visitFunctionExpression(nnode);
        if (node instanceof IfNode nnode) return visitIfNode(nnode);
        if (node instanceof LessThanAndEqualExpression nnode) return visitLessThanAndEqualExpression(nnode);
        if (node instanceof LessThanExpression nnode) return visitLessThanExpression(nnode);
        if (node instanceof MoreThanAndEqualExpression nnode) return visitMoreThanAndEqualExpression(nnode);
        if (node instanceof MoreThanExpression nnode) return visitMoreThanExpression(nnode);
        if (node instanceof MulExpression nnode) return visitMulExpression(nnode);
        if (node instanceof NotEuqalExpression nnode) return visitNotEuqalExpression(nnode);
        if (node instanceof Null nnode) return visitNull(nnode);
        if (node instanceof NumberExpression nnode) return visitNumberExpression(nnode);
        if (node instanceof ObjectNode nnode) return visitObjectNode(nnode);
        if (node instanceof ReturnNode nnode) return visitReturnNode(nnode);
        if (node instanceof RootEnter nnode) return visitRootEnter(nnode);
        if (node instanceof Statement nnode) return visitStatement(nnode);
        if (node instanceof Statements nnode) return visitStatements(nnode);
        if (node instanceof StringExpression nnode) return visitStringExpression(nnode);
        if (node instanceof SubExpression nnode) return visitSubExpression(nnode);
        if (node instanceof UndefinedId nnode) return visitUndefinedId(nnode);
        if (node instanceof UndefinedNode nnode) return visitUndefinedNode(nnode);
        if (node instanceof ValueNode nnode) return visitValueNode(nnode);
        if (node instanceof WhileNode nnode) return visitWhileNode(nnode);
        if (node instanceof NumberBinaryExpression nnode) return visitNumberBinaryExpression(nnode);
        if (node instanceof IdExpression nnode) return visitIdExpression(nnode);
        if (node instanceof ComparisonExpression nnode) return visitComparisonExpression(nnode);
        if (node instanceof BinaryExpression nnode) return visitBinaryExpression(nnode);
        if (node instanceof Expression nnode) return visitExpression(nnode);
        throw new NLException("unsupport node " + node.getClass().getName());
    }

    T visitAddExpression(AddExpression addExpression);

    T visitArrayNode(ArrayNode arrayNode);

    T visitAssignExpression(AssignExpression assignExpression);

    T visitBinaryExpression(BinaryExpression binaryExpression);

    T visitBlockNode(BlockNode blockNode);

    T visitBooleanExpression(BooleanExpression booleanExpression);

    T visitBreakNode(BreakNode breakNode);

    T visitCallExpression(CallExpression callExpression);

    T visitComparisonExpression(ComparisonExpression comparisonExpression);

    T visitContinueNode(ContinueNode continueNode);

    T visitDevExpression(DevExpression devExpression);

    T visitEuqalExpression(EuqalExpression euqalExpression);

    T visitExpression(Expression expression);

    T visitFunctionExpression(FunctionExpression functionExpression);

    T visitIdExpression(IdExpression idExpression);

    T visitIfNode(IfNode ifNode);


    T visitLessThanAndEqualExpression(LessThanAndEqualExpression lessThanAndEqualExpression);

    T visitLessThanExpression(LessThanExpression lessThanExpression);

    T visitMoreThanAndEqualExpression(MoreThanAndEqualExpression moreThanAndEqualExpression);

    T visitMoreThanExpression(MoreThanExpression moreThanExpression);

    T visitMulExpression(MulExpression mulExpression);

    T visitNode(Node node);

    T visitNotEuqalExpression(NotEuqalExpression notEuqalExpression);

    T visitNull(Null nullNode);

    T visitNumberBinaryExpression(NumberBinaryExpression numberBinaryExpression);

    T visitNumberExpression(NumberExpression numberExpression);

    T visitObjectNode(ObjectNode objectNode);

    T visitReturnNode(ReturnNode returnNode);

    T visitRootEnter(RootEnter rootEnter);

    T visitStatement(Statement statement);

    T visitStatements(Statements statements);

    T visitStringExpression(StringExpression stringExpression);

    T visitSubExpression(SubExpression subExpression);

    T visitUndefinedId(UndefinedId undefinedId);

    T visitUndefinedNode(UndefinedNode undefinedNode);

    T visitValueNode(ValueNode valueNode);

    T visitWhileNode(WhileNode whileNode);
}
