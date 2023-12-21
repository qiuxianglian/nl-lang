package nl;


import java.io.*;

public class NlExample {

    public static void main(String[] args) throws Exception {
        NLLang nlLang = new NLLang();
//        Object eval = nlLang.eval(new InputStreamReader((new ByteArrayInputStream("1+1".getBytes()))));
        Object eval2 = nlLang.eval(new InputStreamReader(new FileInputStream(new File("nl/tests/statement7.nl"))));
        System.out.println(eval2);
    }
}
