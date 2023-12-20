package nl.node;




public abstract   class BinaryExpression extends Node {

    protected Node left;
    protected Node right;

    public BinaryExpression(Lang language, Node left, Node right) {
        super(language);
        this.left = left;
        this.right = right;
    }

    public  Node getLeft(){
        return this.left;
    }
    public  Node getRight(){
        return this.right;
    }


    protected Node doUndefined(UndefinedVar left, Object right) {
        return  this;
    }

    protected Node doUndefined(Object left, UndefinedVar right) {
        return  this;
    }



    protected BinaryExpression(Lang language) {
        super(language);
    }
}
