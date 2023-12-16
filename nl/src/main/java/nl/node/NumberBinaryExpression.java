package nl.node;

import com.oracle.truffle.api.TruffleLanguage;

public abstract class NumberBinaryExpression extends BinaryExpression{


    protected NumberBinaryExpression(TruffleLanguage<?> language) {
        super(language);
    }
}
