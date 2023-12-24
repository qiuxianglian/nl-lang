package nl.node;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayNode extends Node{
    private List<Node> nodes;

    public ArrayNode(Lang language, List<Node> nodes) {
        super(language);
        this.nodes = nodes;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return nodes.stream().map(k->k.execute(frame)).collect(Collectors.toList());
    }

    @Override
    protected List<Node> children() {
        return nodes;
    }

    @Override
    public String toString() {
        return nodes+"";
    }
}
