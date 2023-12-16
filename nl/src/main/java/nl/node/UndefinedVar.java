package nl.node;


import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.strings.TruffleString;

public class UndefinedVar  implements TruffleObject {
    private TruffleString name;

    public UndefinedVar(TruffleString name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "未定义变量：" + name ;
    }
}
