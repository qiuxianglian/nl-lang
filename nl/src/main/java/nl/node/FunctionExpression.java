package nl.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.NodeInfo;

import java.util.List;
import java.util.stream.Collectors;


@NodeInfo(shortName = "fn")
public class FunctionExpression extends Node implements TruffleObject {
    private Node body;
//    private List<IdExpression> idExpressions;
    public FunctionExpression(TruffleLanguage<?> language
//            , List<IdExpression> idExpressions
            , Node body) {
        super(language);
        this.body = body;
//        this.idExpressions = idExpressions;
    }
    @Override
    public Object execute(VirtualFrame frame) {
        return this;
    }

    public Node getBody() {
        return body;
    }

//    public List<IdExpression> getIdExpressions() {
//        return idExpressions;
//    }

//    @Override
//    public String toString() {
//        StringBuffer sb = new StringBuffer();
//        if(idExpressions.size()==1){
//            sb.append(idExpressions.stream().findFirst().get());
//        } else {
//            sb.append("(");
//            sb.append(idExpressions.stream().map(com.oracle.truffle.api.nodes.Node::toString).collect(Collectors.joining(",")));
//            sb.append(")");
//        }
//        sb.append("=>");
//        sb.append(body);
//        return sb.toString();
//    }
}
