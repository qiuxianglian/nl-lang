package nl.node;

import nl.BreakException;
import nl.ContinueException;

public class WhileNodeReduce extends WhileNode{
    private WhileNode whileNode;
    public WhileNodeReduce(Lang language, WhileNode whileNode) {
        super(language, whileNode.getCondition(), whileNode.getBody());
        this.whileNode = whileNode;
        this.condition = whileNode.getCondition().copy();
        this.body = whileNode.getBody().copy();
    }

    @Override
    public boolean reducible() {
        return super.reducible();
    }

    @Override
    public Node reduce(VirtualFrame frame) {

        if(condition.reducible()){
            condition = condition.reduce(frame);
            return this;
        }
        Object execute = condition.execute(frame);
        if(execute instanceof Boolean bool && bool){
            try {
                if(body.reducible()){
                    body = body.reduce(frame);
                    return this;
                }else{
                    condition = whileNode.condition.copy();
                    body = whileNode.body.copy();
                    return this;
                }
            }catch (BreakException breakException){
                return Null.NULL;
            }catch (ContinueException ignore){
                return this;
            }
        } else {
            return Null.NULL;
        }

    }
}
