package nl.node;


public  class AddExpression extends NumberBinaryExpression{


    public AddExpression(Lang language, Node left, Node right) {
        super(language, left, right);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return null;
    }

    protected long doLong(long left, long right) {
        return Math.addExact(left, right);
    }


    protected double doDouble(double left, double right) {
        return left + right;
    }

    protected double doDoubleLong(double left, long right) {
        return left + (double) right;
    }
    protected double doLongDouble(long left, double right) {
        return  (double) left +right;
    }



    @Override
    public String toString() {
        return getLeft()+"+"+getRight();
    }


}
