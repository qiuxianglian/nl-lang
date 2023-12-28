package nl.builtin;

import nl.node.*;

import java.util.List;

public class Print extends FunctionExpression {

    public Print(Lang language, List<IdExpression> idExpressions) {
        super(language, idExpressions, new PrintBody(language));
    }


    public static class PrintBody extends BuiltInNode {
        java.io.PrintStream out;

        protected PrintBody(Lang language) {
            super(language);
            out = language.printStream();
        }

        @Override
        public Object execute(VirtualFrame frame) {
            Object[] arguments = frame.getArguments();
            for (int i = 0; i < arguments.length; i++) {
                out.print(arguments[i]);
                if (i != arguments.length - 1) {
                    out.print(" ");
                }
            }
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
            return "builtin fn: print";
        }
    }

}
