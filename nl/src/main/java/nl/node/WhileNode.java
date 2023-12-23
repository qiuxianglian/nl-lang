package nl.node;

import nl.BreakException;
import nl.ContinueException;

import java.util.List;

public class WhileNode extends Node{
    private Node condition;
    private Node body;



    public WhileNode(Lang language, Node condition, Node body) {
        super(language);
        this.condition = condition;
        this.body = body;
    }



    @Override
    public Object execute(VirtualFrame frame) {
        Object finalResult = "";
        while (true){
            Object execute = condition.execute(frame);
            if(execute instanceof Boolean bool && bool){
                try {
                    finalResult = body.execute(frame);
                }catch (BreakException breakException){
                    break;
                }catch (ContinueException ignore){
                }
            } else {
                break;
            }
        }
        return "";
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