package nl;

import nl.node.Node;
import nl.node.VirtualFrame;

public class DFSNLLangRunner implements NLLangRunner{
    @Override
    public Object eval(Node node) {
        VirtualFrame frame = new VirtualFrame();
        Object[] arr;
        NLScope.NLScopeOperator scope;
        scope = NLScope.NLScopeOperator.newScope();
        arr=new Object[2];
        arr[0] = scope;
        frame.setArguments(arr);
        return node.execute(frame);
    }
}
