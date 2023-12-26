package nl.node;

import java.util.List;

public class IfNode extends Node{
    private Node condition;
    private Node body;

    private Node elseBody;

    public IfNode(Lang language, Node condition, Node body,Node elseBody) {
        super(language);
        this.condition = condition;
        this.body = body;
        this.elseBody = elseBody;
    }



    @Override
    public Object execute(VirtualFrame frame) {
        Object execute = condition.execute(frame);
        if(execute instanceof Boolean bool){
            if(bool){
                return body.execute(frame);
            }else if(elseBody!=null){
                return elseBody.execute(frame);
            }
        }
        return Null.NULL;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(condition,body,elseBody);
    }

    @Override
    protected List<Node> children() {
        return List.of(condition,body,elseBody);
    }

    @Override
    public String toString() {
        return "if" +
                "(" + condition +
                ")" + body + (elseBody==null?"":" else "+elseBody);
    }
}
