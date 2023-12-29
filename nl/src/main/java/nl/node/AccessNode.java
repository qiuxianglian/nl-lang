package nl.node;

import nl.NLException;

import java.util.List;
import java.util.Map;

public class AccessNode extends Node{
    private Node node;
    private Node id;

    public AccessNode(Lang language, Node node, Node id) {
        super(language);
        this.node = node;
        this.id = id;
    }

    public Node getNode() {
        return node;
    }

    public Node getId() {
        return id;
    }

    protected Object executeInner(VirtualFrame frame) {
        Object execute = node.execute(frame);
        Object theId = id.execute(frame);
        if(execute instanceof List<?> list){
            if(theId instanceof Number){
                int index = ((Number) theId).intValue();
                if(index>=list.size()-1 ||index<0){
                    return Null.NULL;
                }else{
                    return list.get(index);
                }
            }
        }else if(execute instanceof Map map){
            return map.get(String.valueOf(theId));
        }else if(execute instanceof ArrayNode array){
            return array.getNodes().get(String.valueOf(theId));
        }else if(execute instanceof ObjectNode obj){
            return obj.getNodes().get(String.valueOf(theId));
        }


        throw new NLException("unsupport opt "+execute+"["+theId+"]");
    }

    @Override
    public Object execute(VirtualFrame frame){
        Object o = executeInner(frame);
        if(o == null){
            return Null.NULL;
        }
        return o;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(this.id,this.node);
    }


    @Override
    protected List<Node> children() {
        return List.of(node,id);
    }
}
