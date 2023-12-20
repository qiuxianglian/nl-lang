package nl;

import nl.node.AddExpression;
import nl.node.AddExpressionNodeGen;
import nl.node.NumberExpression;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;

public class NlExample {
    /**
     * The main entry point.
     */
    public static void main(String[] args) throws InterruptedException {
        Context nl = Context.newBuilder(NLMain.NL)
                .allowHostAccess(HostAccess.ALL)
                //allows access to all Java classes
                .allowHostClassLookup(className -> true)
                .build();

        Value o1 = nl.eval(NLMain.NL, "a:=1;a");
        System.out.println(o1);
    }
}
