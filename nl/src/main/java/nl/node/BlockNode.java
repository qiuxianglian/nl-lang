package nl.node;

import nl.NLInnerException;
import nl.NLScope;

import java.util.List;

public class BlockNode extends Node{
    private Node statements;

    public Node getStatements() {
        return statements;
    }

    private  NLScope.NLScopeOperator scope;


    public BlockNode(Lang language, Node statements) {
        super(language);
        this.statements = statements;
    }

    @Override
    public boolean reducible() {
        return true;
    }

    @Override
    public Node copy() {
        return new BlockNode(lang,statements.copy());
    }

    @Override
    public Node reduce(VirtualFrame frame) {
        if(this.scope == null){
            this.scope = frame.getScopeOperator();
            scope.enter();
        }
        if(statements.reducible()){
            NLScope.NLScopeOperator scope = this.scope ;
            try {
                VirtualFrame virtualFrame = new VirtualFrame();
                virtualFrame.setScopeOperator(scope);
                this.statements = statements.reduce(virtualFrame);
                if(!this.statements.reducible()){
                    scope.exit();
                    return this.statements;
                }
                return this;
            }catch (NLInnerException e){
                scope.exit();
                throw e;
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        }else{
            this.scope.exit();
            return this.statements;
        }
    }

    @Override
    public Object execute(VirtualFrame frame) {
        NLScope.NLScopeOperator scope = frame.getScopeOperator();
        scope.enter();
        try {
            Object execute = statements.execute(frame);
            scope.exit();
            return execute;
        }catch (NLInnerException e){
            scope.exit();
            throw e;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(statements);
    }


    @Override
    protected List<Node> children() {
        return List.of(statements);
    }
    private static final String LF = System.getProperty("line.separator");

    @Override
    public String toString() {
        return "{"+LF + statements +
                LF+"}";
    }
}
