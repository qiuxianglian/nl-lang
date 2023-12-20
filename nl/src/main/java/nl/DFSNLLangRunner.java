package nl;

import nl.node.Node;
import nl.node.VirtualFrame;

public class DFSNLLangRunner implements NLLangRunner{
    @Override
    public Object eval(Node node) {
        return node.execute(new VirtualFrame());
    }
}
