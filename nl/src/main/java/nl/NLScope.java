package nl;

import com.oracle.truffle.api.strings.TruffleString;

import java.util.ArrayList;
import java.util.List;


public class NLScope {

    protected final NLScope outer;
    protected final List<TruffleString> index ;
    protected final List<Object> values;

    public NLScope(NLScope outer) {
        this.outer = outer;
        this.index = new ArrayList<>();
        this.values = new ArrayList<>();
    }
    public void put(TruffleString id, Object val){
        innerPut(id,val);
    }

    private void innerPut(TruffleString id, Object val){
        if(id == null) return;
        index.add(id);
        values.add(val);
    }

    private Object innerGet(TruffleString id){
        for (int i = index.size() - 1; i >= 0; i--) {
            TruffleString truffleString = index.get(i);
            if(truffleString.equals(id)){
                return values.get(i);
            }
        }
        return null;
    }

    public Object find(TruffleString name) {
        Object result = innerGet(name);
        if (result != null) {
            return result;
        } else if (outer != null) {
            return outer.find(name);
        } else {
            return null;
        }
    }
}