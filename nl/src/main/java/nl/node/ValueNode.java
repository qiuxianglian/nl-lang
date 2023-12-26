package nl.node;

import java.util.List;

public class ValueNode extends Node{
    private Object value;

    protected ValueNode(Lang language,Object obj) {
        super(language);
        this.value = obj;
    }

    public static Node createIf(Lang lang,Object o){
        if(o instanceof Node oo){
            return oo;
        }else{
            return new ValueNode(lang,o);
        }
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        if(value instanceof Node node){
            return visitor.accept(node);
        }
        return null;
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
