package nl;
import java.util.HashMap;
import java.util.Map;
public class NLScope{

    private static final NLScopeCache nlScopeCache = new NLScopeCache();

    public static NLScopeCache getNlScopeCache(){
        return nlScopeCache;
    }

    public static class NLScopeCache extends ObjCache<NLScope>{

        @Override
        protected NLScope newSelf() {
            return new NLScope(null);
        }

        @Override
        protected void clear(NLScope scope) {
            if(scope == null) return;
            scope.outer = null;
            scope.map.clear();
        }
    }

    static {
        nlScopeCache.initCache(60);
    }

    public static void cyl(NLScope nlScope){
        nlScopeCache.cyl(nlScope);
    }

    public static class NLScopeOperator{
        private static final NLScopeOperatorCache NL_SCOPE_OPERATOR_CACHE = new NLScopeOperatorCache();
        static {
            NL_SCOPE_OPERATOR_CACHE.initCache(20);
        }
        public static NLScopeOperatorCache getNlScopeOperatorCache(){
            return NL_SCOPE_OPERATOR_CACHE;
        }
        public static class NLScopeOperatorCache extends ObjCache<NLScopeOperator>{

            @Override
            protected NLScopeOperator newSelf() {
                return new NLScopeOperator(null);
            }

            @Override
            protected void clear(NLScopeOperator nlScopeOperator) {
                nlScopeOperator.scope = null;
            }
        }

        private static long enterCnt = 0;
        private static long exitCnt = 0;

        public NLScopeOperator() {
            newScopeCnt++;
        }

        public static long getEnterCnt() {
            return enterCnt;
        }

        public static long getExitCnt() {
            return exitCnt;
        }

        private NLScope scope;

        private static long newScopeCnt = 0;

        public static void cyl (NLScopeOperator nlScopeOperator){
            NL_SCOPE_OPERATOR_CACHE.cyl(nlScopeOperator);
        }
        public NLScopeOperator(NLScope scope) {
            this.scope = scope;
        }

        public static long getNewScopeCnt() {
            return newScopeCnt;
        }

        public static NLScopeOperator newScope(){
            NLScope newScope = nlScopeCache.getInstance();
            NLScopeOperator nlScopeOperator = NL_SCOPE_OPERATOR_CACHE.getInstance();
            nlScopeOperator.scope = newScope;
            return nlScopeOperator;
        }

        public void enter(){
            enterCnt++;
            NLScope newNLScope = nlScopeCache.getInstance();
            newNLScope.outer = this.scope;
            this.scope = newNLScope;
        }

        public void exit(){
            exitCnt++;
            if(this.scope.outer == null){
                return;
            }
            NLScope nlScope = this.scope;
            this.scope = this.scope.outer;
            nlScopeCache.cyl(nlScope);
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
    private NLScope(NLScope outer) {
        this.outer = outer;
        init();
        cnt++;
    }

    public static long getCnt() {
        return cnt;
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
        map.put(id,val);
    }

    private Object innerGet(String id){
        if(id == null) return null;
        return map.get(id);
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