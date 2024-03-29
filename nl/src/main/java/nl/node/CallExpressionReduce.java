package nl.node;

import nl.NLReturnException;
import nl.NLScope;

public class CallExpressionReduce extends CallExpression{


    public CallExpressionReduce(Lang language, CallExpression callExpression) {
        super(language, callExpression.functionExpression, callExpression.inputs);
    }

    private VirtualFrame nodeFrame;

    private FunctionExpression cacheFn;

    public VirtualFrame getNodeFrame() {
        return nodeFrame;
    }

    public void setNodeFrame(VirtualFrame nodeFrame) {
        this.nodeFrame = nodeFrame;
    }

    public FunctionExpression getCacheFn() {
        return cacheFn;
    }

    public void setCacheFn(FunctionExpression cacheFn) {
        this.cacheFn = cacheFn;
    }


    @Override
    public Node reduce(VirtualFrame frame) {
        if(nodeFrame==null){
            nodeFrame = frame;
            nodeFrame.setScopeOperator(frame.getScopeOperator());
        }

        if(functionExpression.reducible()){
            Node reduce = functionExpression.reduce(nodeFrame);
            functionExpression = reduce.copy();
            return this;
        }else{
            for (int i = 0; i < inputs.length; i++) {
                Node input = inputs[i];
                if(input.reducible()){
                    inputs[i] = input.reduce(nodeFrame);
                    return this;
                }
            }
        }


        Object function = functionExpression.reduce(nodeFrame);
        if(function instanceof FunctionExpression fn){
            if(cacheFn == null){
                cacheFn = fn;
                NLScope.NLScopeOperator nlScope = NLScope.NLScopeOperator.newScope();
                cacheFn.setScope(nlScope);
                cacheFn.setUpNlScope(nodeFrame.getScopeOperator().getScope());
                Object[] argumentValues = execInputs();
                for (int i = 0; i < cacheFn.getIdExpressions().size(); i++) {
                    IdExpression idExpression = cacheFn.getIdExpressions().get(i);
                    if(i<argumentValues.length){
                        cacheFn.getScope().getScope().put(idExpression.getId(),argumentValues[i]);
                    }
                }

            }
            try {
                if(cacheFn.getBody().reducible()){
                    VirtualFrame virtualFrame = new VirtualFrame();
                    virtualFrame.setArguments(execInputs());
                    virtualFrame.setScopeOperator(cacheFn.getScope());
                    return cacheFn.getBody().reduce(virtualFrame);
                }else {
                    cyl(cacheFn,nodeFrame);
                    return ValueNode.createIf(lang,cacheFn.getBody().execute(nodeFrame));
                }
            } catch (NLReturnException returnException){
                cyl(cacheFn,nodeFrame);
                return ValueNode.createIf(lang,returnException.getResult());
            }
        } else {
            throw new RuntimeException("target is not function ");
        }

        //        return ValueNode.createIf(lang,this.execute(frame));

    }

    private void  cyl(FunctionExpression fn,VirtualFrame nodeFrame){
        NLScope.cyl(fn.getScope().getScope());
        NLScope.NLScopeOperator.cyl(fn.getScope());
        fn.setScope(null);
        VirtualFrame.getFrameCache().cyl(nodeFrame);
    }

    private  Object[] execInputs(){
        Object[] argumentValues = new Object[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            argumentValues[i] = inputs[i].execute(nodeFrame);
        }
        return argumentValues;
    }

}
