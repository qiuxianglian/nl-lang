package nl;

import nl.node.Node;

public class NLReturnException extends NLInnerException{
    private Object result;



    public NLReturnException(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
