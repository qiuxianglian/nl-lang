package nl.node;



import nl.NLScope;

import java.util.List;

public class RootEnter extends Node{
    private Node node;

    public Node getNode() {
        return node;
    }

    public RootEnter(Lang language, Node node) {
        super(language);
        this.node = node;
    }

    @Override
    public boolean reducible() {
        return this.node.reducible();
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        return this.node.reduce(virtualFrame);
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
    public Node copy() {
        return new RootEnter(lang,node.copy());
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(node);
    }

    @Override
    protected List<Node> children() {
        return List.of(node);
    }
}
