package nl;

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
        Value o = nl.eval(NLMain.NL, "((f=>f()))(a=>p)");
        System.out.println(o);
    }
}
