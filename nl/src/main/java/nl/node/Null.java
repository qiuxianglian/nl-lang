package nl.node;

import java.util.List;

public class Null extends Node{
    public static final Null NULL = new Null();
    private Null() {
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
    public boolean reducible() {
        return false;
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        return this;
    }

    @Override
    public String toString() {
        return "null";
    }
}
