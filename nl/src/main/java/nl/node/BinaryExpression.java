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

    public  static BinaryExpression create(Lang lang,Node left,Node right,Class<?extends BinaryExpression> cls){
        if(cls.equals(AddExpression.class)){
            return new AddExpression(lang,left,right);
        }
        if(cls.equals(SubExpression.class)){
            return new SubExpression(lang,left,right);
        }
        if(cls.equals(MulExpression.class)){
            return new MulExpression(lang,left,right);
        }
        if(cls.equals(DevExpression.class)){
            return new DevExpression(lang,left,right);
        }
        throw new NLException("not support binary opt "+cls);
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
        }else if(l instanceof UndefinedId ll){
            return doUndefined(frame,ll,r);
        }else if(r instanceof UndefinedId rr){
            return doUndefined(frame,l,rr);
        }
        if(l instanceof Node ll && ll.hasUndefined()){
            return new UndefinedNode(lang,create(lang,ll, wrapper(lang,frame,r))).execute(frame);
        }
        if(r instanceof Node rr && rr.hasUndefined()){
            return new UndefinedNode(lang,create(lang,wrapper(lang,frame,l), rr)).execute(frame);
        }
        throw new NLException("不支持的类型：left is "+l+"; right is "+r);
    }



    public  Node getLeft(){
        return this.left;
    }
    public  Node getRight(){
        return this.right;
    }


    protected Object doUndefined(VirtualFrame virtualFrame, UndefinedId left, Object right) {
        return  new UndefinedNode(lang,create(lang,left, wrapper(lang,virtualFrame,right))).execute(virtualFrame);
    }

    protected Object doUndefined(VirtualFrame virtualFrame,Object left, UndefinedId right) {
        return  new UndefinedNode(lang,create(lang, wrapper(lang,virtualFrame,left), right)).execute(virtualFrame);
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
