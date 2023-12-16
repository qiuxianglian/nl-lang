package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;

public class StringExpression extends Expression{
    private final TruffleString str;
    public StringExpression(TruffleLanguage<?> language,TruffleString str) {
        super(language);
        this.str = str;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return str;
    }

    @Override
    public String toString() {
        return "\\\\'"+str.toString().replaceAll("'","\\\\'")+"\\\\'";
    }
}
