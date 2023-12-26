package nl.node;


public  class SubExpression extends NumberBinaryExpression{


    public SubExpression(Lang language, Node left, Node right) {
        super(language, left, right);
    }


    protected Object doLong(long left, long right) {
        return Math.subtractExact(left, right);
    }


    protected Object doDouble(double left, double right) {
        return left - right;
    }

    protected Object doDoubleLong(double left, long right) {
        return left - (double) right;
    }
    protected Object doLongDouble(long left, double right) {
        return  (double) left - right;
    }


    @Override
    public String toString() {
        return getLeft()+"+"+getRight();
    }

    @Override
    public BinaryExpression create(Lang language, Node left, Node right) {
        return new SubExpression(language,left,right);
    }
}
