package nl.node;




import nl.NLReturnException;
import nl.NLScope;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




public class CallExpression extends Node {
    private Node functionExpression;
    private final Node[] inputs;

    private VirtualFrame nodeFrame;

    private FunctionExpression cacheFn;

    private Node fnBodyCopy;



    public CallExpression(Lang language, Node functionExpression, Node[] inputs) {
        super(language);
        this.functionExpression = functionExpression;
        this.inputs = inputs;
   }


    @Override
    public Node reduce(VirtualFrame frame) {
        if(functionExpression.reducible()){
            Node reduce = functionExpression.reduce(frame);
            functionExpression = reduce.copy();
            return this;
        }else{
            for (int i = 0; i < inputs.length; i++) {
                Node input = inputs[i];
                if(input.reducible()){
                    inputs[i] = input.reduce(frame);
                    return this;
                }
            }
        }

        return ValueNode.createIf(lang,this.execute(frame));

//        Object function = functionExpression.reduce(frame);
//        if(function instanceof FunctionExpression fn){
//            if(cacheFn == null){
//                cacheFn = fn;
//                NLScope.NLScopeOperator nlScope = NLScope.NLScopeOperator.newScope();
//                cacheFn.setNlScope(nlScope);
//                cacheFn.setUpNlScope(frame.getScope().getScope());
//                Object[] argumentValues = new Object[inputs.length];
//                for (int i = 0; i < inputs.length; i++) {
//                    argumentValues[i] = inputs[i].execute(frame);
//                }
//
//                for (int i = 0; i < cacheFn.getIdExpressions().size(); i++) {
//                    IdExpression idExpression = cacheFn.getIdExpressions().get(i);
//                    if(i<argumentValues.length){
//                        cacheFn.getNlScope().getScope().put(idExpression.getId(),argumentValues[i]);
//                    }
//                }
//
//                if(nodeFrame==null){
//                    nodeFrame = VirtualFrame.getFrameCache().getInstance();
//                    nodeFrame.setArguments(argumentValues);
//                    nodeFrame.setScope(cacheFn.getNlScope());
//                }
//                if(fnBodyCopy == null){
//                    fnBodyCopy = cacheFn.getBody().copy();
//                }
//
//            }
//            try {
//                if(fnBodyCopy.reducible()){
//                    fnBodyCopy = fnBodyCopy.reduce(nodeFrame);
//                    return fnBodyCopy;
//                }else {
//                    cyl(cacheFn,nodeFrame);
//                    return ValueNode.createIf(lang,fnBodyCopy.execute(nodeFrame));
//                }
//            } catch (NLReturnException returnException){
//                cyl(cacheFn,nodeFrame);
//                return ValueNode.createIf(lang,returnException.getResult());
//            }
//        } else {
//            throw new RuntimeException("target is not function ");
//        }
    }

    private void  cyl(FunctionExpression fn,VirtualFrame nodeFrame){
        NLScope.cyl(fn.getNlScope().getScope());
        fn.setNlScope(null);
        NLScope.NLScopeOperator.cyl(fn.getNlScope());
        VirtualFrame.getFrameCache().cyl(nodeFrame);
    }


    @Override
    public Object execute(VirtualFrame frame) {

        Object function = functionExpression.execute(frame);
        if(function instanceof FunctionExpression fn){
            NLScope.NLScopeOperator nlScope = NLScope.NLScopeOperator.newScope();
            fn.setNlScope(nlScope);
            fn.setUpNlScope(frame.getScope().getScope());

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
            frame = VirtualFrame.getFrameCache().getInstance();
            frame.setArguments(argumentValues);
            frame.setScope(fn.getNlScope());
            try {
                Object call = fn.getBody().execute(frame);
                return call;
            } catch (NLReturnException returnException){
                return returnException.getResult();
            }finally {
                NLScope.cyl(nlScope.getScope());
                fn.setNlScope(null);
                NLScope.NLScopeOperator.cyl(nlScope);
                VirtualFrame.getFrameCache().cyl(frame);
            }
        } else {
            throw new RuntimeException("target is not function ");
        }
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
