package nl.node;

import nl.NLScope;

import java.util.List;

public class BlockNode extends Node{
    private Node statements;

    public BlockNode(Lang language, Node statements) {
        super(language);
        this.statements = statements;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        NLScope.NLScopeOperator scope = frame.getScope();
        scope.enter();
        Object execute = statements.execute(frame);
        scope.exit();
        return execute;
    }

    @Override
    protected List<Node> children() {
        return List.of(statements);
    }
}
