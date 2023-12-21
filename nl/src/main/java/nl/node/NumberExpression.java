package nl.node;


import java.util.List;

public  class NumberExpression extends Expression{
    private final Number num;

    public NumberExpression(Lang language, Number num) {
        super(language);

        this.num = num;
    }

    public Number getNum() {
        return num;
    }

    @Override
    public String toString() {
        return num+"";
    }


    @Override
    public Object execute(VirtualFrame frame) {
        return num;
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }
}
