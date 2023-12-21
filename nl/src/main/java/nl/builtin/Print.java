package nl.builtin;

import nl.node.*;

import java.util.List;

public class Print extends FunctionExpression {

    public Print(Lang language, List<IdExpression> idExpressions) {
        super(language, idExpressions, new PrintBody(language));
    }


    public static class PrintBody extends Node {

        protected PrintBody(Lang language) {
            super(language);
        }

        @Override
        public Object execute(VirtualFrame frame) {
            Object[] arguments = frame.getArguments();
            for (int i = 0; i < arguments.length; i++) {
                System.out.print(arguments[i]);
                if (i != arguments.length - 1) {
                    System.out.print(" ");
                }
            }
            return "";
        }

        @Override
        protected List<Node> children() {
            return List.of();
        }
    }

}