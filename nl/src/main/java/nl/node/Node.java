package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;

@NodeInfo(language = "NL", description = "The abstract base node for all NL node")
public abstract class Node extends RootNode {
    protected Node(TruffleLanguage<?> language) {
        super(language);
    }

    protected Node(TruffleLanguage<?> language, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }


}
