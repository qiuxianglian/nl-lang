package nl.node;

import nl.BreakException;
import nl.ContinueException;

import java.util.List;

public class WhileNode extends Node{
    protected Node condition;
    protected Node body;

    public Node getCondition() {
        return condition;
    }

    public Node getBody() {
        return body;
    }

    public WhileNode(Lang language, Node condition, Node body) {
        super(language);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public Node reduce(VirtualFrame frame) {
        return new ReduceWhileNode(lang,this);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        while (true){
            Object execute = condition.execute(frame);
            if(execute instanceof Boolean bool && bool){
                try {
                    body.execute(frame);
                }catch (BreakException breakException){
                    break;
                }catch (ContinueException ignore){
                }
            } else {
                break;
            }
        }
        return Null.NULL;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(condition,body);
    }

    @Override
    protected List<Node> children() {
        return List.of(condition,body);
    }

    @Override
    public String toString() {
        return "while" +
                "(" + condition +
                ")" + body ;
    }
}
