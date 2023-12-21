package nl.node;


import java.util.List;

public class UndefinedId extends IdExpression{

    public UndefinedId(Lang language, String id) {
        super(language, id);
    }



//    @Override
//    public Object execute(VirtualFrame frame) {
//        return this;
//    }

    public boolean hasUndefined(){
        return true;
    }

    public boolean isUndefined(){

        return true;
    }

    @Override
    protected List<Node> children() {
        return List.of();
    }
}
