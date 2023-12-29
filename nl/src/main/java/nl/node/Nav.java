package nl.node;


public class Nav extends UnaryOperationNode{


    public Nav(Lang language, Node target) {
        super(language, target);
    }

    @Override
    protected Object doNull(Null nullVal) {
        return Null.NULL;
    }

    protected long doLong(long obj){
        return -obj;
    }

    protected double doDouble(double obj){
        return -obj;
    }



}
