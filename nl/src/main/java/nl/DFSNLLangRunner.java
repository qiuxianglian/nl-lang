package nl;

import nl.node.Node;
import nl.node.VirtualFrame;

public class DFSNLLangRunner implements NLLangRunner{
    @Override
    public Object eval(Node node) {
        VirtualFrame frame = new VirtualFrame();
        NLScope.NLScopeOperator scope = NLScope.NLScopeOperator.newScope();
        frame.setScope(scope);
        return node.execute(frame);
    }
}
