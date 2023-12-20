package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.TruffleObject;


public class FunctionBodyExpression extends Node implements TruffleObject {
    private Node body;


    public FunctionBodyExpression(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, Node body) {
        super(language,frameDescriptor);
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return body.execute(frame);
    }



    public Node getBody() {
        return body;
    }

    @Override
    public String toString() {
        return body.toString();
    }
}
