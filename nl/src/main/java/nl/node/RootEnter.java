package nl.node;



import nl.NLScope;

import java.util.List;

public class RootEnter extends Node{
    private Node node;

    public RootEnter(Lang language, Node node) {
        super(language);
        this.node = node;
    }


    @Override
    public String toString() {
        return node.toString();
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
        VirtualFrame virtualFrame = new VirtualFrame();
        virtualFrame.setArguments(arr);
        return node.execute(virtualFrame);
    }

    @Override
    protected List<Node> children() {
        return List.of(node);
    }
}
