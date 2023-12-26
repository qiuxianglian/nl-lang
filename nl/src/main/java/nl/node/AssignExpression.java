package nl.node;



import nl.NLException;
import nl.NLScope;

import java.util.List;
import java.util.Map;

public class AssignExpression extends Node{
    private Node id;
    private Node expression;

    public AssignExpression(Lang language, Node id, Node expression) {
        super(language);
        this.id = id;
        this.expression = expression;
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        if(expression.reducible()){
            this.expression = expression.reduce(virtualFrame);
        }

        return ValueNode.createIf(lang,this.execute(virtualFrame));
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object execute = expression.execute(frame);
        NLScope.NLScopeOperator argument = frame.getScope();
        if(id instanceof IdExpression iid){
            argument.getScope().putOrUpdate(iid.getId(),execute);
        }else if(id instanceof AccessNode accessNode){
            execute(frame,accessNode,execute);
        }

        return execute;
    }

    @Override
    public Node copy() {
        return new AssignExpression(lang,id.copy(),expression.copy());
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(id,expression);
    }


    private Object execute(VirtualFrame frame, AccessNode accessNode, Object newVal) {
        Object execute = accessNode.getNode().execute(frame);
        Object theId = accessNode.getId().execute(frame);
        if(execute instanceof List list){
            if(theId instanceof Number){
                int index = ((Number) theId).intValue();
                if(index>=list.size()-1 ||index<0){
                    return Null.NULL;
                }else{
                    return list.set(index,newVal);
                }
            }
        }else if(execute instanceof Map map){
            return map.put(theId+"",newVal);
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
