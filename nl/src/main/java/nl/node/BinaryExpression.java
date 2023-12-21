package nl.node;


import nl.NLException;

import java.util.List;

public abstract   class BinaryExpression extends Node {

    protected Node left;
    protected Node right;

    public BinaryExpression(Lang language, Node left, Node right) {
        super(language);
        this.left = left;
        this.right = right;
    }

    abstract public BinaryExpression create(Lang language, Node left, Node right);

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
            return doUndefined(frame,ll,r);
        }else if(r instanceof UndefinedVar rr){
            return doUndefined(frame,l,rr);
        }
        if(l instanceof Node ll && ll.hasUndefined()){
            return create(lang,ll, wrapper(r,frame));
        }
        if(r instanceof Node rr && rr.hasUndefined()){
            return create(lang,wrapper(l,frame), rr);
        }
        throw new NLException("不支持的类型：left is "+l+"; right is "+r);
    }

    private Node wrapper(Object o,VirtualFrame virtualFrame){
        if(o instanceof Node){
            return (Node) ((Node) o).execute(virtualFrame);
        }
        return new ValueNode(lang,o);
    }

    public  Node getLeft(){
        return this.left;
    }
    public  Node getRight(){
        return this.right;
    }


    protected Node doUndefined(VirtualFrame virtualFrame,UndefinedVar left, Object right) {
        return  create(lang,left, wrapper(right,virtualFrame));
    }

    protected Node doUndefined(VirtualFrame virtualFrame,Object left, UndefinedVar right) {
        return  create(lang, wrapper(left,virtualFrame), right);
    }

    abstract protected long doLong(long left, long right) ;


    abstract protected double doDouble(double left, double right) ;

    abstract protected double doDoubleLong(double left, long right) ;
    abstract protected double doLongDouble(long left, double right);

    protected BinaryExpression(Lang language) {
        super(language);
    }

    @Override
    protected List<Node> children() {
        return List.of(getLeft(),getRight());
    }
}
