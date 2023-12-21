package nl.node;


import java.util.List;

public class UndefinedId extends Node{
    private String name;

    public UndefinedId(Lang lang, String name) {
        super(lang);
        this.name = name;
    }

    @Override
    public String toString() {
        return ""+name ;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return this;
    }

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
