package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import nl.NLScope;

public class RootEnter extends Node{
    private Node node;

    public RootEnter(TruffleLanguage<?> language, Node node) {
        super(language);
        this.node = node;
    }



    @Override
    public Object execute(VirtualFrame frame) {
        Object[] arr;
        NLScope.NLScopeOperator scope;
        if(frame.getArguments()!=null && frame.getArguments().length>0 && frame.getArguments()[0]!=null){
            scope = (NLScope.NLScopeOperator) frame.getArguments()[0];
            arr = frame.getArguments();
        }else{
            scope = NLScope.NLScopeOperator.newScope();
            arr=new Object[2];
            arr[0] = scope;
        }
        return node.getRootNode().getCallTarget().call(arr);
    }
}
