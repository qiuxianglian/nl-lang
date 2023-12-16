package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;

public class IdExpression extends Expression{
    private TruffleString id;
    private Integer pos;


    public IdExpression(TruffleLanguage<?> language, TruffleString id, Integer pos) {
        super(language);
        this.id = id;
        this.pos = pos;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if(pos == null){
             return id;
        }
        return frame.getObject(pos);
    }

    public Integer getPos() {
        return pos;
    }

    public IdExpression setPos(int pos) {
        this.pos = pos;
        return this;
    }

    public TruffleString getId() {
        return id;
    }

    @Override
    public String toString() {
        return  id.toString() ;
    }
}
