package nl;

import nl.builtin.BuiltIn;
import nl.node.Lang;
import nl.node.Node;
import nl.node.VirtualFrame;

public class SmalStepNLLangRunner implements NLLangRunner {
    @Override
    public Object eval(Lang lang, Node node) {
        Node currentNode = node;
        while (currentNode.executable()) {
            Object reduce = node.reduce();
            if (reduce instanceof Node rNode) {
                currentNode = rNode;
            } else {
                return reduce;
            }
        }
        return currentNode;
    }
}
