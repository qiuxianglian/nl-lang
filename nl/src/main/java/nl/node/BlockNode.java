package nl.node;

import nl.NLInnerException;
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
        try {
            Object execute = statements.execute(frame);
            scope.exit();
            return execute;
        }catch (NLInnerException e){
            scope.exit();
            throw e;
        }
    }

    @Override
    protected List<Node> children() {
        return List.of(statements);
    }
    private static final String LF = System.getProperty("line.separator");

    @Override
    public String toString() {
        return "{"+LF + statements +
                LF+"}";
    }
}
