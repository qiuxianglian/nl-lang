package nl.node;



import nl.NLScope;

import java.util.List;

public class AssignExpression extends Node{
    private IdExpression id;
    private Node expression;

    public AssignExpression(Lang language, IdExpression id, Node expression) {
        super(language);
        this.id = id;
        this.expression = expression;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object execute = expression.execute(frame);
        NLScope.NLScopeOperator argument = frame.getScope();
        argument.getScope().putOrUpdate(id.getId(),execute);
        return execute;
    }

    @Override
    protected List<Node> children() {
        return List.of(id,expression);
    }
}
