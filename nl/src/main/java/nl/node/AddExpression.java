package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "+")
public abstract class AddExpression extends NumberBinaryExpression{

    protected AddExpression(TruffleLanguage<?> language) {
        super(language);
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long doLong(long left, long right) {
        return Math.addExact(left, right);
    }


    @Specialization(rewriteOn = ArithmeticException.class)
    protected double doDouble(double left, double right) {
        return left + right;
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected double doDoubleLong(double left, long right) {
        return left + (double) right;
    }
    @Specialization(rewriteOn = ArithmeticException.class)
    protected double doLongDouble(long left, double right) {
        return  (double) left +right;
    }



    @Override
    public String toString() {
        return getLeft()+"+"+getRight();
    }


}
