package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.strings.TruffleString;

public class UndefinedVar extends Node implements TruffleObject {
    private TruffleString name;

    public UndefinedVar(TruffleLanguage<?> language, TruffleString name) {
        super(language);
        this.name = name;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return this;
    }

//    @Override
//    public String toString() {
//        return "未定义变量：" + name ;
//    }
}
