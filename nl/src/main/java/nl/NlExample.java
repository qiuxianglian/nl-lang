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
//        Value o = nl.eval(NLMain.NL, "(x=>y=>x)(1)(2)");

        Value o1 = nl.eval(NLMain.NL, "(2*1+2+7.5)*3/1.2*22-99");
        System.out.println(o1);
    }
}
