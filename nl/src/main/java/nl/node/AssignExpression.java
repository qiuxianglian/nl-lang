package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import nl.NLScope;

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
        Object execute = expression.execute(frame);
        NLScope.NLScopeOperator argument = ( NLScope.NLScopeOperator) frame.getArguments()[0];
        argument.getScope().put(id.getId(),execute);
        return execute;
    }
}
