package nl.node;




import nl.NLScope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




public class CallExpression extends Node {
    private Node functionExpression;
    private final Node[] inputs;



    public CallExpression(Lang language, Node functionExpression, Node[] inputs) {
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

            for (int i = 0; i < fn.getIdExpressions().size(); i++) {
                IdExpression idExpression = fn.getIdExpressions().get(i);
                if(i<argumentValues.length){
                    fn.getNlScope().getScope().put(idExpression.getId(),argumentValues[i]);
                }
            }
            frame = new VirtualFrame();
            frame.setScope(fn.getNlScope());
            Object call = fn.getBody().execute(frame);
            return call;
        } else {
            throw new RuntimeException("target is not function ");
        }
    }

    @Override
    protected List<Node> children() {
        List<Node> functionExpression1 = new java.util.ArrayList<>(List.of(functionExpression));
        functionExpression1.addAll(Arrays.asList(inputs));
        return functionExpression1;
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
        sb.append(Arrays.stream(inputs).map(k->k.toString()).collect(Collectors.joining(",")));
        sb.append(")");

        return sb.toString();
    }
}
