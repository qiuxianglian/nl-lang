package nl.builtin;

import nl.node.*;

import java.util.List;

public class NowTimeMillis extends FunctionExpression {
    public NowTimeMillis(Lang language, List<IdExpression> idExpressions) {
        super(language, idExpressions, new NowTimeMillisBody(language));
    }


    public static class NowTimeMillisBody extends Node {

        protected NowTimeMillisBody(Lang language) {
            super(language);
        }

        @Override
        public Object execute(VirtualFrame frame) {
            return System.currentTimeMillis();
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
            return "builtin fn: nowTimeMillis";
        }
    }

}
