package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.dsl.NodeChild;


@NodeChild("left")
@NodeChild("right")
public abstract   class BinaryExpression extends Node {


    public abstract Node getLeft();
    public abstract Node getRight();




    protected BinaryExpression(TruffleLanguage<?> language) {
        super(language);
    }
}
