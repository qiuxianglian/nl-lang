package nl.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayNode extends ObjectNode{


    public ArrayNode(Lang language, Map<String, Node> nodes) {
        super(language, nodes);
    }

    @Override
    public String toString() {
        return NodeToString.nodeToString(this);
    }
}
