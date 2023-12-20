package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleStringBuilder;
import nl.NLScope;

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
        NLScope.NLScopeOperator scope = (NLScope.NLScopeOperator) frame.getArguments()[0];

        Object function = functionExpression.execute(frame);
        if(function instanceof FunctionExpression fn){

            Object[] argumentValues = new Object[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                argumentValues[i] = inputs[i].execute(frame);
            }

            for (int i = 0; i < fn.getIdExpressions().size(); i++) {
                IdExpression idExpression = fn.getIdExpressions().get(i);
                if(i<argumentValues.length){
                    scope.getScope().put(idExpression.getId(),argumentValues[i]);
                }
            }

            Object call = fn.getBody().execute(frame);
            return call;
        } else {
            throw new RuntimeException("target is not function ");
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(functionExpression instanceof IdExpression||functionExpression instanceof CallExpression){
            sb.append(functionExpression);
        }else{
            sb.append("(");
            sb.append(functionExpression);
            sb.append(")");
        }
        sb.append("(");
        sb.append(Arrays.stream(inputs).map(com.oracle.truffle.api.nodes.Node::toString).collect(Collectors.joining(",")));
        sb.append(")");

        return sb.toString();
    }
}
