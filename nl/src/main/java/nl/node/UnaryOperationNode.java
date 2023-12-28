package nl.node;

abstract public class UnaryOperationNode extends Node{
    protected Node target;

    public UnaryOperationNode(Lang language, Node target) {
        super(language);
        this.target = target;
    }

    public Node getTarget() {
        return target;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object execute = target.execute(frame);
        if (execute instanceof Long l) {
            return doLong(l);
        } else if (execute instanceof Double d) {
            return doDouble(d);
        } else if (execute instanceof Null) {
            return Null.NULL;
        } else {
            return ValueNode.createIf(lang, execute);
        }
    }

    abstract protected Object doNull(Null nullVal);

     abstract protected long doLong(long obj);
    abstract protected double doDouble(double obj);

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(target);
    }
}
