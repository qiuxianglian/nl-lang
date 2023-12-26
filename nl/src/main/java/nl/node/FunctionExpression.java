package nl.node;




import nl.NLScope;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class FunctionExpression extends Node  {
    private Node body;
    private List<IdExpression> idExpressions;
    public FunctionExpression(Lang language
            , List<IdExpression> idExpressions
            , Node body) {
        super(language);
        this.body = body;
        this.idExpressions = idExpressions;
    }
    @Override
    protected List<Node> children() {
        List<Node> body1 = new java.util.ArrayList<>(List.of(getBody()));
        body1.addAll(idExpressions);
        return body1;
    }
    @Override
    public Object execute(VirtualFrame frame) {
        FunctionExpression functionExpression = new FunctionExpression(lang, idExpressions, body);
        return functionExpression;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.aggResult(visitor.accept(body),visitor.accept(idExpressions));
    }


    private NLScope.NLScopeOperator nlScope;

    public FunctionExpression setUpNlScope(NLScope nlScope) {
        this.nlScope.setOuter(nlScope);
        return this;
    }

    public void setNlScope(NLScope.NLScopeOperator nlScope) {
        this.nlScope = nlScope;
    }

    public NLScope.NLScopeOperator getNlScope() {
        return nlScope;
    }

    public Node getBody() {
        return body;
    }

    public List<IdExpression> getIdExpressions() {
        return idExpressions;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(idExpressions.size()==1){
            sb.append(idExpressions.stream().findFirst().get());
        } else {
            sb.append("(");
            sb.append(idExpressions.stream().map(k->toString()).collect(Collectors.joining(",")));
            sb.append(")");
        }
        sb.append("=>");
        sb.append(body);
        return sb.toString();
    }
}
