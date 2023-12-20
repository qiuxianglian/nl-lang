package nl.node;




public class Statement extends Node{
    private Node node;

    public Statement(Lang language, Node node) {
        super(language);
        this.node = node;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return node.execute(frame);
    }
}
