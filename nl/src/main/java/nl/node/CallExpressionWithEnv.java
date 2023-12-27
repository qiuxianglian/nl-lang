package nl.node;

import nl.NLReturnException;
import nl.NLScope;

public class CallExpressionWithEnv extends CallExpression{
    public CallExpressionWithEnv(Lang language, Node functionExpression, Node[] inputs) {
        super(language, functionExpression, inputs);
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
            nodeFrame.setScope(frame.getScope());
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
                cacheFn.setUpNlScope(nodeFrame.getScope().getScope());
                Object[] argumentValues = new Object[inputs.length];
                for (int i = 0; i < inputs.length; i++) {
                    argumentValues[i] = inputs[i].execute(nodeFrame);
                }

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
                    virtualFrame.setScope(cacheFn.getScope());
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
        fn.setScope(null);
        NLScope.NLScopeOperator.cyl(fn.getScope());
        VirtualFrame.getFrameCache().cyl(nodeFrame);
    }

}
