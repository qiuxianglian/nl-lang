package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import nl.node.Node;

public abstract class Expression extends Node  {
    protected Expression(TruffleLanguage<?> language) {
        super(language);
    }

}
