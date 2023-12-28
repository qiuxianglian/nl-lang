package nl.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectNode extends Node{
    protected Map<String,Object> nodes;

    public Map<String, Object> getNodes() {
        return nodes;
    }

    public ObjectNode(Lang language, Map<String,Node> nodes) {
        super(language);
        this.nodes = new HashMap<>();
        this.nodes.putAll(nodes);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        for (Map.Entry<String, Object> stringNodeEntry : nodes.entrySet()) {
            String key = stringNodeEntry.getKey();
            Object value = stringNodeEntry.getValue();
            if(value instanceof Node){
                value = ((Node) value).execute(frame);
            }
            nodes.put(key,value);
        }
        return nodes;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        T res = null;
        for (Map.Entry<String, Object> stringObjectEntry : nodes.entrySet()) {
            Object value = stringObjectEntry.getValue();
            if(value instanceof Node node){
                if(res!=null){
                    res=visitor.aggResult(res,visitor.accept(node));
                }else{
                    res = visitor.accept(node);
                }
            }
        }
        return res;
    }



    @Override
    protected List<Node> children() {
        return List.of();
    }

    @Override
    public String toString() {
        return nodes.values().stream().toList()+"";
    }
}
