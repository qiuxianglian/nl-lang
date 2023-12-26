package nl.node;

public class HasUndefinedVisitor implements VisitorAdapter<Boolean>{

    public static final HasUndefinedVisitor hasUndefinedVisitor  = new HasUndefinedVisitor();
    @Override
    public Boolean visitUndefinedId(UndefinedId undefinedId) {
        return true;
    }

    @Override
    public Boolean aggResult(Boolean t1, Boolean t2) {
        if(t1) return true;
        return t2;
    }
}
