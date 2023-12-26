package nl;

import nl.node.Lang;
import nl.node.Node;
import nl.node.VirtualFrame;

public class SmalStepNLLangRunner implements NLLangRunner {
    @Override
    public Object eval(Lang lang, Node node) {
        NLScope.NLScopeOperator scope = NLScope.NLScopeOperator.newScope();

        VirtualFrame instance = VirtualFrame.getFrameCache().getInstance();
        instance.setScope(scope);
        Node currentNode = node;
        lang.printStream().println(currentNode);
        lang.printStream().println("===============================");
        while (currentNode.reducible()) {
            Object reduce = currentNode.reduce(instance);
            lang.printStream().println(currentNode);
            lang.printStream().println("===============================");
            if (reduce instanceof Node rNode) {
                currentNode = rNode;
            } else {
                return null;
            }
        }
        VirtualFrame.getFrameCache().cyl(instance);
        return currentNode;
    }
}
