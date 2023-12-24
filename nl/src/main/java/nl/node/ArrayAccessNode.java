package nl.node;

import nl.NLException;

import java.util.List;

public class ArrayAccessNode extends Node{
    private Node node;
    private Node id;

    public ArrayAccessNode(Lang language, Node node, Node id) {
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

    @Override
    public Object execute(VirtualFrame frame) {
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
        }
        throw new NLException("unsupport opt "+execute+"["+theId+"]");
    }

    @Override
    protected List<Node> children() {
        return List.of(node,id);
    }
}
