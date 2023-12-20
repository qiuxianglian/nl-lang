package nl.node;




public class FunctionBodyExpression extends Node  {
    private Node body;


    public FunctionBodyExpression(Lang language,  Node body) {
        super(language);
        this.body = body;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return body.execute(frame);
    }



    public Node getBody() {
        return body;
    }

    @Override
    public String toString() {
        return body.toString();
    }
}
