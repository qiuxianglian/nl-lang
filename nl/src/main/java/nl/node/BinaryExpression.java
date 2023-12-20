package nl.node;


import nl.NLException;

public abstract   class BinaryExpression extends Node {

    protected Node left;
    protected Node right;

    public BinaryExpression(Lang language, Node left, Node right) {
        super(language);
        this.left = left;
        this.right = right;
    }
    public Object execute(VirtualFrame frame) {
        Object l = getLeft().execute(frame);
        Object r = getRight().execute(frame);
        if(l instanceof Long tl && r instanceof Long lr){
            return doLong(tl,lr);
        }else if(l instanceof Long ll && r instanceof Double rr){
            return doLongDouble(ll,rr);
        }else if(l instanceof Double ll && r instanceof Long rr){
            return doDoubleLong(ll,rr);
        }else if(l instanceof Double ll && r instanceof Double rr){
            return doDouble(ll,rr);
        }else if(l instanceof UndefinedVar ll){
            return doUndefined(ll,r);
        }else if(r instanceof UndefinedVar rr){
            return doUndefined(l,rr);
        }
        return new NLException("不支持的类型："+l+", "+r);
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

    abstract protected long doLong(long left, long right) ;


    abstract protected double doDouble(double left, double right) ;

    abstract protected double doDoubleLong(double left, long right) ;
    abstract protected double doLongDouble(long left, double right);

    protected BinaryExpression(Lang language) {
        super(language);
    }
}
