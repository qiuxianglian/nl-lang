package nl.node;


import java.util.List;

public class UndefinedId extends IdExpression{

    public UndefinedId(Lang language, String id) {
        super(language, id);
    }


    @Override
    protected List<Node> children() {
        return List.of();
    }
}
