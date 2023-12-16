package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.TruffleObject;

import java.util.List;

public class FunctionBodyExpression extends Node implements TruffleObject {
    private List<WriteVarExpression> localVars;
    private Node body;


    public FunctionBodyExpression(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, List<WriteVarExpression> localVars, Node body) {
        super(language,frameDescriptor);
        this.localVars = localVars;
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        for (int i = 0; i < localVars.size(); i++) {
            WriteVarExpression writeVarExpression = localVars.get(i);
            writeVarExpression.execute(frame);
        }
        return body.execute(frame);
    }

    public List<WriteVarExpression> getLocalVars() {
        return localVars;
    }

    public Node getBody() {
        return body;
    }

    @Override
    public String toString() {
        return body.toString();
    }
}
