package nl.node;


import java.util.List;

public class BooleanExpression extends Node{
    private boolean bool;

    public boolean isBool() {
        return bool;
    }

    public BooleanExpression(Lang language, boolean bool) {
        super(language);
        this.bool = bool;
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        return ValueNode.createIf(lang,bool);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return bool;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept();
    }


    @Override
    protected List<Node> children() {
        return List.of();
    }

    @Override
    public String toString() {
        return bool+"";
    }
}
