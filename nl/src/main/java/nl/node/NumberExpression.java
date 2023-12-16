package nl.node;


import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;

public  class NumberExpression extends Expression{
    private final Number num;

    public NumberExpression(TruffleLanguage<?> language, Number num) {
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
}
