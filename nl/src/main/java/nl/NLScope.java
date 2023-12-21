package nl;



import java.util.HashMap;
import java.util.Map;


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
    protected Map<String,Object> map;


    public NLScope(NLScope outer) {
        this.outer = outer;
        init();
    }

    private void init(){
        this.map = new HashMap<>();
    }
    public void put(String id, Object val){
        innerPut(id,val);
    }

    public  void putOrUpdate(String id,Object val){
        if(!putOrUpdate(this, id, val)){
            put(id,val);
        }
    }

    private static boolean putOrUpdate(NLScope scope,String id,Object val){
        Object result = scope.innerGet(id);
        if (result != null) {
            scope.put(id,val);
            return true;
        } else if (scope.outer != null) {
             if(putOrUpdate(scope.outer,id,val)){
                 return true;
             }else{
                 return false;
             }
        } else {
            return false;
        }
    }

    private void innerPut(String id, Object val){
        if(id == null) return;
        map.put(id,val);
    }

    private Object innerGet(String id){
        return map.get(id);
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