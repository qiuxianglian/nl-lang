package nl.node;




import java.util.ArrayList;
import java.util.List;

public class Statements extends Node{
    private List<Node> statements;

    public Statements(Lang language, List<Node> statements) {
        super(language);
        this.statements = statements;
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
    protected List<Node> children() {
        return statements;
    }
}
