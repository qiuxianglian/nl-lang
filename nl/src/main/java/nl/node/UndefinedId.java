package nl.node;


import java.util.List;

public class UndefinedId extends IdExpression{

    public UndefinedId(Lang language, String id) {
        super(language, id);
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
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }
}
