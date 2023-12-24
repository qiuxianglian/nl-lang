package nl.node;

import nl.BreakException;

import java.util.List;

public class BreakNode extends Node{
    public BreakNode(Lang language) {
        super(language);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw BreakException.BREAK_EXCEPTION;
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }

    @Override
    public String toString() {
        return "break";
    }
}
