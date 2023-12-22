package nl.node;


import java.util.List;

public class Statement extends Node{
    private Node node;

    public Statement(Lang language, Node node) {
        super(language);
        this.node = node;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return node.execute(frame);
    }

    @Override
    protected List<Node> children() {
        return List.of(node);
    }

    @Override
    public String toString() {
        return node +";";
    }
}
