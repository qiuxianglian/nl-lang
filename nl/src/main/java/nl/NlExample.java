package nl;




import java.io.*;

public class NlExample {

    public static void main(String[] args) throws Exception {
        NLLang nlLang = new NLLang();
        nlLang.setDebug(true);
        //30*20+40/(2*4+1+1)
//        Object eval =
//                nlLang.eval(new InputStreamReader((new ByteArrayInputStream("a=10; b=9+7; c=a*b".getBytes()))));
//        Object eval = nlLang.eval(new InputStreamReader(
//                new FileInputStream("./nl/tests/smallstep/namedFn1.nl")));
        Object eval = nlLang.eval(new InputStreamReader(
                new FileInputStream("./nl/tests/smallstep/lambda8.nl")));
        System.out.print(eval);
        System.out.println();
//        ObjCache.stats(nlLang);
    }
}
