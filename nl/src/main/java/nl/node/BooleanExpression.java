package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;

public class BooleanExpression extends Node{
    private boolean bool;

    public BooleanExpression(TruffleLanguage<?> language, boolean bool) {
        super(language);
        this.bool = bool;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return bool;
    }
}
