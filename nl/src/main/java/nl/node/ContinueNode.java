package nl.node;

import nl.BreakException;
import nl.ContinueException;

import java.util.List;

import static nl.ContinueException.CONTINUE_EXCEPTION;

public class ContinueNode extends Node{
    public ContinueNode(Lang language) {
        super(language);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw CONTINUE_EXCEPTION;
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }

    @Override
    public String toString() {
        return "continue";
    }
}
