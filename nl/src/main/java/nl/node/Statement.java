package nl.node;


import java.util.List;

public class Statement extends Node{
    private Node node;

    public Node getNode() {
        return node;
    }

    public Statement(Lang language, Node node) {
        super(language);
        this.node = node;
    }

    @Override
    public Node copy() {
        return new Statement(lang,node.copy());
    }

    @Override
    public boolean reducible() {
        return node.reducible();
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        return node.reduce(virtualFrame);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return node.execute(frame);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(node);
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
