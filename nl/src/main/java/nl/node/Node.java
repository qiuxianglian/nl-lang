package nl.node;


import java.util.List;

public abstract class Node {
    private static long cnt = 0;

    protected Lang lang;
    protected Node(Lang language) {
        this.lang = language;
        cnt++;
    }

    public boolean reducible(){
        return true;
    }

     public Node reduce(VirtualFrame frame){
        return ValueNode.createIf(lang,execute(frame));
    }


    public boolean hasUndefined(){
        return HasUndefinedVisitor.hasUndefinedVisitor.visit(this);
    }

    public static long getCnt() {
        return cnt;
    }
    private static long executeCnt = 0;
    public abstract Object execute(VirtualFrame frame);

    public  Node copy(){
        return this;
    }


    abstract public <T> T accept(Visitor<T> visitor);


    public static Node wrapper(Lang lang,VirtualFrame virtualFrame,Object o){
        return new ValueNode(lang,o);
    }

    protected List<Node> children(){
        return List.of();
    }


}
