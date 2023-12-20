package nl.node;




public class BooleanExpression extends Node{
    private boolean bool;

    public BooleanExpression(Lang language, boolean bool) {
        super(language);
        this.bool = bool;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return bool;
    }
}
