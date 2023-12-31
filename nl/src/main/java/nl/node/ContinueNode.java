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
    public Node reduce(VirtualFrame frame) {
        throw CONTINUE_EXCEPTION;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw CONTINUE_EXCEPTION;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return null;
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
