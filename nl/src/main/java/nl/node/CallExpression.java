package nl.node;




import nl.NLReturnException;
import nl.NLScope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




public class CallExpression extends Node {
    protected Node functionExpression;
    protected final Node[] inputs;

    public Node getFunctionExpression() {
        return functionExpression;
    }

    public Node[] getInputs() {
        return inputs;
    }

    public CallExpression(Lang language, Node functionExpression, Node[] inputs) {
        super(language);
        this.functionExpression = functionExpression;
        this.inputs = inputs;
   }

    @Override
    public Node reduce(VirtualFrame frame) {
        return new CallExpressionReduce(lang,this).reduce(frame);
    }

    @Override
    public Object execute(VirtualFrame frame) {

        Object function = functionExpression.execute(frame);
        if(!(function instanceof FunctionExpression fn)){
            throw new RuntimeException("target is not function "+function);
        }
        // 如果函数作用域不为空，说明是含有值的函数。否则继承当前的作用域
        if(fn.getScope()==null){
            fn = assignScope(fn,frame.getScopeOperator());
        }

        Object[] argumentValues = new Object[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            argumentValues[i] = inputs[i].execute(frame);
        }

        for (int i = 0; i < fn.getIdExpressions().size(); i++) {
            IdExpression idExpression = fn.getIdExpressions().get(i);
            if(i<argumentValues.length){
                fn.getScope().getScope().put(idExpression.getId(),argumentValues[i]);
            }
        }
        VirtualFrame newFrame = VirtualFrame.getFrameCache().getInstance();
        newFrame.setArguments(argumentValues);

        newFrame.setScopeOperator(fn.getScope());
        try {
            Object call = fn.getBody().execute(newFrame);
            // 如果返回值是函数，继承当前函数作用域的scope
            if(call instanceof FunctionExpression callFN){
                return assignScope(callFN,newFrame.getScopeOperator());
            }
            return call;
        } catch (NLReturnException returnException){
            Object result = returnException.getResult();
            if(result instanceof FunctionExpression callFN){
                return assignScope(callFN,newFrame.getScopeOperator());
            }
            return result;
        }
        finally {
            VirtualFrame.getFrameCache().cyl(newFrame);
        }
    }


    private FunctionExpression assignScope(FunctionExpression callFN, NLScope.NLScopeOperator scope){
        FunctionExpression nfn = new FunctionExpression(lang, callFN.getIdExpressions(), callFN.getBody());
        nfn.setScope(NLScope.NLScopeOperator.newScope());
        nfn.setUpNlScope(scope.getScope());
        return nfn;
    }

    @Override
    public Node copy() {
        Node[] nodes = new Node[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            nodes[i] = inputs[i].copy();
        }
        return new CallExpression(lang,functionExpression.copy(),nodes);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.aggResult(visitor.accept(functionExpression),visitor.accept(inputs));
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
