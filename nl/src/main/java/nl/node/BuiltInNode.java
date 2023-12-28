package nl.node;

public abstract class BuiltInNode extends Node{
    protected BuiltInNode(Lang language) {
        super(language);
    }

    @Override
    public Node reduce(VirtualFrame frame) {
        return ValueNode.createIf(lang,execute(frame));
    }
}
