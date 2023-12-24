package nl;


import nl.node.Node;
import nl.node.VirtualFrame;

import java.io.*;

public class NlExample {

    public static void main(String[] args) throws Exception {
        NLLang nlLang = new NLLang();
        nlLang.setDebug(true);
//        Object eval = nlLang.eval(new InputStreamReader((new ByteArrayInputStream("1+1".getBytes()))));
        Object eval2 = nlLang.eval(new InputStreamReader(new FileInputStream("./nl/tests/fib.nl")));
        System.out.print(eval2);
        System.out.println("virtual cnt "+VirtualFrame.getCnt());
        System.out.println("node cnt "+ Node.getCnt());
        System.out.println("scope cnt "+NLScope.getCnt());
        System.out.println("NLScopeOperator getNewScopeCnt cnt "+ NLScope.NLScopeOperator.getNewScopeCnt());
    }
}
