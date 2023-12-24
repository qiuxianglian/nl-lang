package nl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NLScope {

    public static class NLScopeOperator{
        private NLScope scope;

        private static long newScopeCnt = 0;

        public NLScopeOperator(NLScope scope) {
            this.scope = scope;
        }

        public static long getNewScopeCnt() {
            return newScopeCnt;
        }

        public static NLScopeOperator newScope(){
            newScopeCnt++;
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

    private static long cnt = 0;
    public NLScope(NLScope outer) {
        this.outer = outer;
//        init();
        initList();
        cnt++;
    }

    public static long getCnt() {
        return cnt;
    }

    private List<String> ids;
    private List<Object> vals;
    private void initList(){
        ids = new ArrayList<>();
        vals = new ArrayList<>();
    }
    private void init(){
        this.map = new HashMap<>();
    }
    public void put(String id, Object val){
        innerPut(id,val);
    }

    public  void putOrUpdate(String id,Object val){
        if(!putOrUpdateWhile(this, id, val)){
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

    private static boolean putOrUpdateWhile(NLScope scope,String id,Object val){
        NLScope current = scope;
        while (true){
            Object result = current.innerGet(id);
            if (result != null) {
                current.put(id,val);
                return true;
            }
            if(current.outer == null){
                return false;
            }
            current = current.outer;
        }
    }

    private void innerPut(String id, Object val){
        if(id == null) return;
//        map.put(id,val);
        ids.add(id);
        vals.add(val);
    }

    private Object innerGet(String id){
        if(id == null) return null;
//        return map.get(id);
        for (int i = ids.size() - 1; i >= 0; i--) {
            String curId = ids.get(i);
            if(id.equals(curId)){
                return vals.get(i);
            }
        }
        return null;
    }

    public Object find(String name) {
        return find(this,name);
    }

    private static Object find(NLScope scope,String name){
        NLScope current = scope;
        while (true){
            Object result = current.innerGet(name);
            if(result != null){
                return result;
            }
            if(current.outer == null){
                return result;
            }
            current = current.outer;
        }
    }
}