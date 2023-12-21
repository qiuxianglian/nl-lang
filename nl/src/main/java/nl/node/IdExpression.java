package nl.node;



import nl.NLScope;

import java.util.List;

public class IdExpression extends Expression{
    private String id;

    public IdExpression(Lang language, String id) {
        super(language);
        this.id = id;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if(frame.getArguments().length == 0){
            return new UndefinedVar(lang,id);
        }
        NLScope.NLScopeOperator argument = ( NLScope.NLScopeOperator) frame.getArguments()[0];
        Object o = argument.getScope().find(id);
        if(o == null){
            return new UndefinedVar(lang,id);
        }
        return o;
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return  id.toString() ;
    }
}
