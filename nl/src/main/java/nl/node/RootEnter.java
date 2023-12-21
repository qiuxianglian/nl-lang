package nl.node;



import nl.NLScope;

import java.util.List;

public class RootEnter extends Node{
    private Node node;

    public RootEnter(Lang language, Node node) {
        super(language);
        this.node = node;
    }


    @Override
    public String toString() {
        return node.toString();
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return node.execute(frame);
    }

    @Override
    protected List<Node> children() {
        return List.of(node);
    }
}
