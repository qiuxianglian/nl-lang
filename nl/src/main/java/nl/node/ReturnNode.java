package nl.node;

import nl.NLReturnException;

import java.util.List;

public class ReturnNode extends Node {
    private Node value;

    public ReturnNode(Lang language, Node value) {
        super(language);
        this.value = value;
    }

    @Override
    public boolean reducible() {
        return super.reducible();
    }


    @Override
    public Node copy() {
        return new ReturnNode(lang,value==null?null:value.copy());
    }

    @Override
    public Node reduce(VirtualFrame frame) {
        if(value.reducible()){
            value = value.reduce(frame);
            return this;
        }else{
            return ValueNode.createIf(lang,value.execute(frame));
        }
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object execute = "";
        if(value!=null){
            execute = value.execute(frame);
        }
        throw new NLReturnException(execute);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(value);
    }

    @Override
    protected List<Node> children() {
        return List.of(value);
    }

    @Override
    public String toString() {
        return "\treturn" + (value==null?"":" "+ value);
    }
}
