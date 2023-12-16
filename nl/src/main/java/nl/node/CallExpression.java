package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;

import java.util.Arrays;
import java.util.stream.Collectors;


public class CallExpression extends Node {
    private Node functionExpression;
    @Children private final Node[] inputs;



    public CallExpression(TruffleLanguage<?> language, Node functionExpression, Node[] inputs) {
        super(language);
        this.functionExpression = functionExpression;
        this.inputs = inputs;
   }

    @Override
    public Object execute(VirtualFrame frame) {
        Object function = functionExpression.execute(frame);
        if(function instanceof FunctionExpression fn){
            Object[] argumentValues = new Object[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                argumentValues[i] = inputs[i].execute(frame);
            }
            return fn.getBody().getRootNode().getCallTarget().call(argumentValues);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "("+functionExpression +")(" + Arrays.stream(inputs).map(com.oracle.truffle.api.nodes.Node::toString).collect(Collectors.joining(",")) +")";
    }

    //
//    @Override
//    public Object execute(VirtualFrame frame) {
//
//        Object function = functionExpression.execute(frame);
//        Object[] argumentValues = new Object[inputs.length];
//        for (int i = 0; i < inputs.length; i++) {
//            argumentValues[i] = inputs[i].execute(frame);
//        }
//
//        try {
//            return library.execute(function, argumentValues);
//        } catch (ArityException | UnsupportedTypeException | UnsupportedMessageException e) {
//            /* Execute was not successful. */
//            throw new RuntimeException("error exec function");
//        }
//    }
}
