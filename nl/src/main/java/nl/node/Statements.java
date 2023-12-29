package nl.node;




import java.util.ArrayList;
import java.util.List;

public class Statements extends Node{
    private List<Node> statements;

    public List<Node> getStatements() {
        return statements;
    }

    public Statements(Lang language, List<Node> statements) {
        super(language);
        this.statements = statements;
    }


    @Override
    public boolean reducible() {
        return true;
    }

    @Override
    public Node copy() {
        ArrayList<Node> newStats = new ArrayList<>(statements.size());
        for (int i = 0; i < statements.size(); i++) {
            Node node = statements.get(i);
            newStats.add(node.copy());
        }
        return new Statements(lang,newStats);
    }

    @Override
    public Node reduce(VirtualFrame virtualFrame) {
        if(statements.size()==1){
            return statements.get(0).reduce(virtualFrame);
        }
        for (int i = 0; i < this.statements.size(); i++) {
            Node node = statements.get(i);
            if(node.reducible()){
                statements.set(i,node.reduce(virtualFrame));
                return this;
            } else{
                statements.remove(i);
                return this;
            }
        }
        return this;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object res = null;
        for (int i = 0; i < statements.size(); i++) {
            res = statements.get(i).execute(frame);
        }
        return res;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.accept(statements);
    }

    @Override
    protected List<Node> children() {
        return statements;
    }
    private static final String LF = System.getProperty("line.separator");

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < statements.size(); i++) {
            sb.append(statements.get(i));
            if(i!=statements.size()-1){
                sb.append(LF);
            }
        }
        return sb.toString();
    }
}
