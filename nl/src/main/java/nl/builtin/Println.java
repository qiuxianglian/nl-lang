package nl.builtin;

import nl.node.*;

import java.util.List;

public class Println extends FunctionExpression {

    public Println(Lang language, List<IdExpression> idExpressions) {
        super(language, idExpressions, new PrintlnBody(language));
    }


    public static class PrintlnBody extends BuiltInNode {
        java.io.PrintStream out;

        protected PrintlnBody(Lang language) {
            super(language);
            this.out = language.printStream();
        }

        @Override
        public Object execute(VirtualFrame frame) {
            NodeToString node = new NodeToString();
            Object[] arguments = frame.getArguments();
            for (int i = 0; i < arguments.length; i++) {
                out.print(node.toString(arguments[i]));
                if (i != arguments.length - 1) {
                    out.print(" ");
                }
            }
            out.println();
            return "";
        }

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return null;
        }

        @Override
        protected List<Node> children() {
            return List.of();
        }

        @Override
        public String toString() {
            return "builtin fn: println";
        }
    }

}
