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

    @Override
    public Node copy() {
        return create(lang,left.copy(),right.copy(),this.getClass());
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
        if(cls.equals(MoreThanAndEqualExpression.class)){
            return new MoreThanAndEqualExpression(lang,left,right);
        }
        if(cls.equals(MoreThanExpression.class)){
            return new MoreThanExpression(lang,left,right);
        }
        if(cls.equals(LessThanAndEqualExpression.class)){
            return new LessThanAndEqualExpression(lang,left,right);
        }
        if(cls.equals(LessThanExpression.class)){
            return new LessThanExpression(lang,left,right);
        }
        if(cls.equals(EuqalExpression.class)){
            return new EuqalExpression(lang,left,right);
        }
        if(cls.equals(NotEuqalExpression.class)){
            return new NotEuqalExpression(lang,left,right);
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

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        if(getLeft().reducible()){
            left = left.reduce(virtualFrame);
            return this;
        }
        if(getRight().reducible()){
            right = right.reduce(virtualFrame);
            return this;
        }
        return ValueNode.createIf(lang,this.execute(virtualFrame));
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(left,right);
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

    abstract protected Object doLong(long left, long right) ;


    abstract protected Object doDouble(double left, double right) ;

    abstract protected Object doDoubleLong(double left, long right) ;
    abstract protected Object doLongDouble(long left, double right);

    protected BinaryExpression(Lang language) {
        super(language);
    }

    @Override
    protected List<Node> children() {
        return List.of(getLeft(),getRight());
    }


}
