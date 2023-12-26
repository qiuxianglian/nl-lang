package nl.node;

public class Reciprocal extends UnaryOperationNode{


    public Reciprocal(Lang language, Node target) {
        super(language, target);
    }

    @Override
    protected Object doNull(Null nullVal) {
        return Null.NULL;
    }

    @Override
    protected long doLong(long obj) {
        return 1/obj;
    }

    @Override
    protected double doDouble(double obj) {
        return 1/obj;
    }
}
