package nl.node;

import nl.NLScope;
import nl.ObjCache;

public class VirtualFrame {

    private static VirtualFrameCache FRAME_CACHE = new VirtualFrameCache();

    public static VirtualFrameCache getFrameCache() {
        return FRAME_CACHE;
    }

    static {
        FRAME_CACHE.initCache(20);
    }

    public static class VirtualFrameCache extends ObjCache<VirtualFrame>{

        @Override
        protected VirtualFrame newSelf() {
            return new VirtualFrame();
        }

        @Override
        protected void clear(VirtualFrame virtualFrame) {
            virtualFrame.arguments = null;
            virtualFrame.scope = null;
        }
    }

    private static  long cnt = 0;

    public VirtualFrame() {
        cnt++;
    }

    public static long getCnt() {
        return cnt;
    }

    private Object [] arguments;

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    private NLScope.NLScopeOperator scope;

    public NLScope.NLScopeOperator getScope() {
        return scope;
    }

    public VirtualFrame setScope(NLScope.NLScopeOperator scope) {
        this.scope = scope;
        return this;
    }
}
