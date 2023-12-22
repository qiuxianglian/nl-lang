package nl.node;

public  class NotEuqalExpression extends ComparisonExpression {
    public NotEuqalExpression(Lang language, Node left, Node right) {
        super(language, left, right);
    }

    @Override
    public BinaryExpression create(Lang language, Node left, Node right) {
        return new NotEuqalExpression(language,left,right);
    }

    @Override
    protected Object doLong(long left, long right) {
        return left!=right;
    }

    @Override
    protected Object doDouble(double left, double right) {
        return left!=right;
    }

    @Override
    protected Object doDoubleLong(double left, long right) {
        return left!=right;
    }

    @Override
    protected Object doLongDouble(long left, double right) {
        return left!=right;
    }

    @Override
    public String toString() {
        return  left + "!=" + right;
    }
}
