package nl.node;

import java.util.List;

public class ValueNode extends Node{
    private Object value;

    protected ValueNode(Lang language,Object obj) {
        super(language);
        this.value = obj;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return value;
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }

    public Object getValue() {
        return value;
    }


    @Override
    public String toString() {
        return value +"";
    }
}
