package nl;




import java.io.*;

public class NlExample {

    public static void main(String[] args) throws Exception {
        NLLang nlLang = new NLLang();
        nlLang.setDebug(true);
//        Object eval = nlLang.eval(new InputStreamReader((new ByteArrayInputStream("1+1".getBytes()))));
        Object eval2 = nlLang.eval(new InputStreamReader(
                new FileInputStream("./nl/tests/obj2.nl")));
        System.out.print(eval2);
        System.out.println();
        ObjCache.stats(nlLang);
    }
}
