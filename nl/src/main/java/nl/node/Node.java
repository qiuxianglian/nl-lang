package nl.node;


import java.util.List;

public abstract class Node {
    protected Lang lang;
    protected Node(Lang language) {
        this.lang = language;
    }
    public abstract Object execute(VirtualFrame frame);

    public boolean hasUndefined(){
        if(isUndefined()) return true;
        for (Node child : children()) {
            if(child!=null && child.hasUndefined()){
                return true;
            }
        }
        return false;
    }

    public boolean isUndefined(){

        return false;
    }

    abstract protected List<Node> children();

    public static Node wrapper(Lang lang,VirtualFrame virtualFrame,Object o){
//        if(o instanceof Node){
//            return (Node) ((Node) o).execute(virtualFrame);
//        }
        return new ValueNode(lang,o);
    }
}
