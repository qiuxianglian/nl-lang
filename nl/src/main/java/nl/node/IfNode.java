package nl.node;

import java.util.List;

public class IfNode extends Node{
    private Node condition;
    private Node body;

    private Node elseBody;

    public Node getCondition() {
        return condition;
    }

    public Node getBody() {
        return body;
    }

    public Node getElseBody() {
        return elseBody;
    }

    public IfNode(Lang language, Node condition, Node body, Node elseBody) {
        super(language);
        this.condition = condition;
        this.body = body;
        this.elseBody = elseBody;
    }


    @Override
    public boolean reducible() {
        return super.reducible();
    }

    @Override
    public Node copy() {
        return new IfNode(lang,condition.copy(),body.copy()
                ,elseBody==null?null:elseBody.copy());
    }

    @Override
    public Node reduce(VirtualFrame frame) {
        if(condition.reducible()){
            condition = condition.reduce(frame);
            return this;
        }
        Object execute = condition.execute(frame);
        if(execute instanceof Boolean bool){
            if(bool){
                return body;
            }else if(elseBody!=null){
                return elseBody;
            }
        }
        return Null.NULL;
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
