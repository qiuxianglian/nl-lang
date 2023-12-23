package nl;

import nl.node.Node;

public class NLReturnException extends RuntimeException{
    private Object result;

    public NLReturnException(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
