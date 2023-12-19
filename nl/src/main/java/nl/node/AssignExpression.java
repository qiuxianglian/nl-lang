package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;

public class AssignExpression extends Node{
    private IdExpression id;
    private Node expression;

    public AssignExpression(TruffleLanguage<?> language, IdExpression id, Node expression) {
        super(language);
        this.id = id;
        this.expression = expression;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return 1;
    }
}
