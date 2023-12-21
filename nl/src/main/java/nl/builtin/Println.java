package nl.builtin;

import nl.node.*;

import java.util.List;

public class Println extends FunctionExpression {

    public Println(Lang language, List<IdExpression> idExpressions) {
        super(language, idExpressions, new PrintlnBody(language));
    }


    public static class PrintlnBody extends Node {

        protected PrintlnBody(Lang language) {
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
            System.out.println();
            return "";
        }

        @Override
        protected List<Node> children() {
            return List.of();
        }
    }

}
