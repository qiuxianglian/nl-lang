package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import nl.NLScope;

public class IdExpression extends Expression{
    private TruffleString id;

    public IdExpression(TruffleLanguage<?> language, TruffleString id) {
        super(language);
        this.id = id;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        NLScope argument = (NLScope) frame.getArguments()[0];
        Object o = argument.find(id);
        if(o == null){
            return new UndefinedVar(id);
        }
        return o;
    }

    public TruffleString getId() {
        return id;
    }

    @Override
    public String toString() {
        return  id.toString() ;
    }
}
