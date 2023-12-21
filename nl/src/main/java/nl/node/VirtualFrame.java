package nl.node;

import nl.NLScope;

public class VirtualFrame {
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
