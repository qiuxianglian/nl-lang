package nl.node;

import java.util.List;

public class Null extends Node{
    public static final Null NULL = new Null();
    public Null() {
        super(null);
    }

    public Null(Lang language) {
        super(language);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return this;
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
        return "null";
    }
}
