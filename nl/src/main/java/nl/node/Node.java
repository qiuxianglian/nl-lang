package nl.node;



public abstract class Node {
    protected Node(Lang language) {

    }
    public abstract Object execute(VirtualFrame frame);
}
