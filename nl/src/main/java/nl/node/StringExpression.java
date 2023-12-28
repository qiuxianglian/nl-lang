package nl.node;


import java.util.List;

public class StringExpression extends Expression{
    private final String str;
    public StringExpression(Lang language,String str) {
        super(language);
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return str;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept();
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }

    @Override
    public String toString() {
        return "\\\\'"+str.replaceAll("'","\\\\'")+"\\\\'";
    }
}
