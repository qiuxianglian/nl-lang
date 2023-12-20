package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;

public class Statement extends Node{
    private Node node;

    public Statement(TruffleLanguage<?> language, Node node) {
        super(language);
        this.node = node;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return node.execute(frame);
    }
}
