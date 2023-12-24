package nl.node;



import nl.NLException;
import nl.NLScope;

import java.util.List;

public class AssignExpression extends Node{
    private Node id;
    private Node expression;

    public AssignExpression(Lang language, Node id, Node expression) {
        super(language);
        this.id = id;
        this.expression = expression;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object execute = expression.execute(frame);
        NLScope.NLScopeOperator argument = frame.getScope();
        if(id instanceof IdExpression iid){
            argument.getScope().putOrUpdate(iid.getId(),execute);
        }else if(id instanceof ArrayAccessNode accessNode){
            execute(frame,accessNode,execute);
        }

        return execute;
    }

    private Object execute(VirtualFrame frame,ArrayAccessNode arrayAccessNode,Object newVal) {
        Object execute = arrayAccessNode.getNode().execute(frame);
        Object theId = arrayAccessNode.getId().execute(frame);
        if(execute instanceof List list){
            if(theId instanceof Number){
                int index = ((Number) theId).intValue();
                if(index>=list.size()-1 ||index<0){
                    return Null.NULL;
                }else{
                    return list.set(index,newVal);
                }
            }
        }
        throw new NLException("unsupport opt "+execute+"["+theId+"]");
    }

    @Override
    protected List<Node> children() {
        return List.of(id,expression);
    }

    @Override
    public String toString() {
        return  id +
                "=" + expression;
    }
}
