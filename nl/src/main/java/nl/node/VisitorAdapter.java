package nl.node;

import nl.NLException;

public interface VisitorAdapter<T> extends Visitor<T> {

    @Override
    default T visitNav(Nav node) {
        return visitUnaryOperationNode(node);
    }

    @Override
    default T visitReciprocal(Reciprocal node) {
        return visitUnaryOperationNode(node);
    }

    @Override
    default T visitUnaryOperationNode(UnaryOperationNode node) {
        return visitNode(node);
    }

    default T visitAddExpression(AddExpression addExpression) {
        return visitNumberBinaryExpression(addExpression);
    }

    default T visitArrayNode(ArrayNode arrayNode) {
        return visitObjectNode(arrayNode);
    }

    default T visitAssignExpression(AssignExpression assignExpression) {
        return visitNode(assignExpression);
    }

    default T visitBinaryExpression(BinaryExpression binaryExpression) {
        return visitNode(binaryExpression);
    }

    default T visitBlockNode(BlockNode blockNode) {
        return visitNode(blockNode);
    }

    default T visitBooleanExpression(BooleanExpression booleanExpression) {
        return visitNode(booleanExpression);
    }

    default T visitBreakNode(BreakNode breakNode) {
        return visitNode(breakNode);
    }

    default T visitCallExpression(CallExpression callExpression) {
        return visitNode(callExpression);
    }

    default T visitComparisonExpression(ComparisonExpression comparisonExpression) {
        return visitNode(comparisonExpression);
    }

    default T visitContinueNode(ContinueNode continueNode) {
        return visitNode(continueNode);
    }

    default T visitDevExpression(DevExpression devExpression) {
        return visitNode(devExpression);
    }

    default T visitEuqalExpression(EuqalExpression euqalExpression) {
        return visitNode(euqalExpression);
    }

    default T visitExpression(Expression expression) {
        return visitNode(expression);
    }

    default T visitFunctionExpression(FunctionExpression functionExpression) {
        return visitNode(functionExpression);
    }

    default T visitIdExpression(IdExpression idExpression) {
        return visitNode(idExpression);
    }

    default T visitIfNode(IfNode ifNode) {
        return visitNode(ifNode);
    }


    default T visitLessThanAndEqualExpression(LessThanAndEqualExpression lessThanAndEqualExpression) {
        return visitNode(lessThanAndEqualExpression);
    }

    default T visitLessThanExpression(LessThanExpression lessThanExpression) {
        return visitNode(lessThanExpression);
    }

    default T visitMoreThanAndEqualExpression(MoreThanAndEqualExpression moreThanAndEqualExpression) {
        return visitNode(moreThanAndEqualExpression);
    }

    default T visitMoreThanExpression(MoreThanExpression moreThanExpression) {
        return visitNode(moreThanExpression);
    }

    default T visitMulExpression(MulExpression mulExpression) {
        return visitNode(mulExpression);
    }

    default T visitNode(Node node) {
        throw new NLException("un-impl visit node " + node.getClass().getName());
    }

    default T visitNotEuqalExpression(NotEuqalExpression notEuqalExpression) {
        return visitNode(notEuqalExpression);
    }

    default T visitNull(Null nullNode) {
        return visitNode(nullNode);
    }

    default T visitNumberBinaryExpression(NumberBinaryExpression numberBinaryExpression) {
        return visitNode(numberBinaryExpression);
    }

    default T visitNumberExpression(NumberExpression numberExpression) {
        return visitNode(numberExpression);
    }

    default T visitObjectNode(ObjectNode objectNode) {
        return visitNode(objectNode);
    }

    default T visitReturnNode(ReturnNode returnNode) {
        return visitNode(returnNode);
    }

    default T visitRootEnter(RootEnter rootEnter) {
        return visitNode(rootEnter);
    }

    default T visitStatement(Statement statement) {
        return visitNode(statement);
    }

    default T visitStatements(Statements statements) {
        return visitNode(statements);
    }

    default T visitStringExpression(StringExpression stringExpression) {
        return visitNode(stringExpression);
    }

    default T visitSubExpression(SubExpression subExpression) {
        return visitNode(subExpression);
    }

    default T visitUndefinedId(UndefinedId undefinedId) {
        return visitNode(undefinedId);
    }

    default T visitUndefinedNode(UndefinedNode undefinedNode) {
        return visitNode(undefinedNode);
    }

    default T visitValueNode(ValueNode valueNode) {
        return visitNode(valueNode);
    }

    default T visitWhileNode(WhileNode whileNode) {
        return visitNode(whileNode);
    }
}
