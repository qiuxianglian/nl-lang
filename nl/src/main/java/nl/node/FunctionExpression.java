package nl.node;




import nl.NLScope;

import java.util.ArrayList;
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
    public boolean reducible() {
        return false;
    }

    @Override
    public Node copy() {
        Node newBody = body.copy();
        List<IdExpression> newIds = new ArrayList<>(idExpressions.size());
        for (IdExpression idExpression : idExpressions) {
            newIds.add((IdExpression) idExpression.copy());
        }
        return new FunctionExpression(lang,newIds,newBody);
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        return this.copy();
    }

    @Override
    public Object execute(VirtualFrame frame) {
//        FunctionExpression functionExpression = new FunctionExpression(lang, idExpressions, body);
//        NLScope.NLScopeOperator nlScope = NLScope.NLScopeOperator.newScope();
//        functionExpression.setScope(nlScope);
//        functionExpression.setUpNlScope(frame.getScope().getScope());
//
//        return functionExpression;
        return this;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.aggResult(visitor.accept(body),visitor.accept(idExpressions));
    }


    private NLScope.NLScopeOperator scope;

    public FunctionExpression setUpNlScope(NLScope nlScope) {
        this.scope.setOuter(nlScope);
        return this;
    }

    public void setScope(NLScope.NLScopeOperator scope) {
        this.scope = scope;
    }

    public NLScope.NLScopeOperator getScope() {
        return scope;
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
