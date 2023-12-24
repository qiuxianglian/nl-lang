package nl;

import nl.node.Lang;
import nl.node.Node;
import nl.node.VirtualFrame;

import java.util.ArrayList;

abstract public class ObjCache<T> {

    private final ArrayList<T> cache = new ArrayList<>();

    private long offerCnt = 0;
    private long newCnt = 0;
    private long cylCnt = 0;

    public void debug(Lang lang){
        lang.printStream().println("offerCacheCnt "+offerCnt+", new "+newCnt+", cyl "+cylCnt+", has "+cache.size());
    }

    abstract protected T newSelf();
    protected abstract void  clear(T t);

    public  void initCache(int cnt){
        for (int i = 0; i < cnt; i++) {
            T nlScope = newSelf();
            cyl(nlScope);
        }
    }

    public   T getInstance(){
        if(cache.size() == 0){
            newCnt++;
            T scope = newSelf();
            return scope;
        }else {
            T scope = cache.remove(cache.size()-1);
            offerCnt++;
            return scope;
        }
    }


    public   void cyl(T nlScope){
        clear(nlScope);
        cache.add(nlScope);
        cylCnt++;
    }

    public static void stats(Lang lang){
        lang.printStream().println("virtual cnt "+VirtualFrame.getCnt());
        lang.printStream().println("node cnt "+ Node.getCnt());
        lang.printStream().println("scope cnt "+NLScope.getCnt());
        lang.printStream().println("NLScopeOperator getNewScopeCnt cnt "+ NLScope.NLScopeOperator.getNewScopeCnt());

        lang.printStream().print("NLScope cache ");
        NLScope.getNlScopeCache().debug(lang);
        lang.printStream().print("NLScopeOperator cache ");
        NLScope.NLScopeOperator.getNlScopeOperatorCache().debug(lang);
        lang.printStream().print("virtualFrame cache ");
        VirtualFrame.getFrameCache().debug(lang);
    }
}
