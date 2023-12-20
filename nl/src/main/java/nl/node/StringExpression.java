package nl.node;




public class StringExpression extends Expression{
    private final String str;
    public StringExpression(Lang language,String str) {
        super(language);
        this.str = str;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return str;
    }

    @Override
    public String toString() {
        return "\\\\'"+str.replaceAll("'","\\\\'")+"\\\\'";
    }
}
