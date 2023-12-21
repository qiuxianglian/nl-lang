package nl.node;

import java.util.List;

public class IfNode extends Node{
    private Node condition;
    private Node body;

    public IfNode(Lang language, Node condition, Node body) {
        super(language);
        this.condition = condition;
        this.body = body;
    }



    @Override
    public Object execute(VirtualFrame frame) {
        Object execute = condition.execute(frame);
        if(execute instanceof Boolean bool){
            if(bool){
                return body.execute(frame);
            }
        }
        return "";
    }

    @Override
    protected List<Node> children() {
        return List.of(condition,body);
    }
}
