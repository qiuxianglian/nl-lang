package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;


@NodeChild("left")
@NodeChild("right")
public abstract   class BinaryExpression extends Node {


    public abstract Node getLeft();
    public abstract Node getRight();


    @Specialization(rewriteOn = ArithmeticException.class)
    protected Node doUndefined(UndefinedVar left, Object right) {
        return  this;
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected Node doUndefined(Object left, UndefinedVar right) {
        return  this;
    }



    protected BinaryExpression(TruffleLanguage<?> language) {
        super(language);
    }
}
