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
        return "return" + (value==null?"":" "+ value);
    }
}
