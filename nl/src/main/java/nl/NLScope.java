package nl;


import java.util.ArrayList;
import java.util.List;


public class NLScope {

    public static class NLScopeOperator{
        private NLScope scope;

        public NLScopeOperator(NLScope scope) {
            this.scope = scope;
        }

        public static NLScopeOperator newScope(){
            return new NLScopeOperator(new NLScope(null));
        }

        public void enter(){
            this.scope = new NLScope(this.scope);
        }

        public void exit(){
            if(this.scope.outer == null){
                return;
            }
            this.scope = this.scope.outer;
        }

        public void setOuter(NLScope nlScope){
            this.scope.outer = nlScope;
        }

        public NLScope getScope() {
            return scope;
        }
    }

    protected  NLScope outer;
    protected  List<String> index ;
    protected  List<Object> values;

    public NLScope(NLScope outer) {
        this.outer = outer;
        init();
    }

    private void init(){
        this.index = new ArrayList<>();
        this.values = new ArrayList<>();
    }
    public void put(String id, Object val){
        innerPut(id,val);
    }

    private void innerPut(String id, Object val){
        if(id == null) return;
        index.add(id);
        values.add(val);
    }

    private Object innerGet(String id){
        for (int i = index.size() - 1; i >= 0; i--) {
            String truffleString = index.get(i);
            if(truffleString.equals(id)){
                return values.get(i);
            }
        }
        return null;
    }

    public Object find(String name) {
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