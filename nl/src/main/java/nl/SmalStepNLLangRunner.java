package nl;

import nl.node.Lang;
import nl.node.Node;
import nl.node.NodeToString;
import nl.node.VirtualFrame;

public class SmalStepNLLangRunner implements NLLangRunner {
    @Override
    public Object eval(Lang lang, Node node) {
        NLScope.NLScopeOperator scope = NLScope.NLScopeOperator.newScope();
        VirtualFrame instance = VirtualFrame.getFrameCache().getInstance();
        instance.setScope(scope);
        Node currentNode = node;
        int i = 0;
        lang.printStream().println("////////////////初始////////////////");
        lang.printStream().println(NodeToString.nodeToString(currentNode));
        while (currentNode.reducible()) {
            Object reduce = currentNode.reduce(instance);
            lang.printStream().println("////////////////第"+i+"步////////////////");
            lang.printStream().println(NodeToString.nodeToString(currentNode));
            if (reduce instanceof Node rNode) {
                currentNode = rNode;
            } else {
                return null;
            }
            i++;
        }
        lang.printStream().println("////////////////结束////////////////");
        VirtualFrame.getFrameCache().cyl(instance);
        return currentNode;
    }
}
