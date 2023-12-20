package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import nl.NLScope;

import java.util.List;

public class Statements extends Node{
    private List<Node> statements;

    public Statements(TruffleLanguage<?> language, List<Node> statements) {
        super(language);
        this.statements = statements;
    }


    @Override
    public Object execute(VirtualFrame frame) {


        Object res = null;
        for (Node statement : statements) {
            res = statement.execute(frame);
        }
        return res;
    }
}
