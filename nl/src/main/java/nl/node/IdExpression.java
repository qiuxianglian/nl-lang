package nl.node;



import nl.NLScope;

import java.util.List;

public class IdExpression extends Expression{
    private String id;

    public IdExpression(Lang language, String id) {
        super(language);
        this.id = id;
    }

    @Override
    public boolean reducible() {
        return super.reducible();
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        return ValueNode.createIf(lang,execute(virtualFrame));
    }

    @Override
    public Node copy() {
        return new IdExpression(lang,id);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        NLScope.NLScopeOperator argument = frame.getScopeOperator();
        Object o = argument.getScope().find(id);
        if(o == null){
            return new UndefinedId(lang,id);
        }
        return o;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return  id.toString() ;
    }
}
