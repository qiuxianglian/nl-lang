package nl;


import java.io.*;

public class NlExample {

    public static void main(String[] args) throws Exception {
        NLLang nlLang = new NLLang();
//        Object eval = nlLang.eval(new InputStreamReader((new ByteArrayInputStream("1+1".getBytes()))));
        Object eval2 = nlLang.eval(new InputStreamReader(new FileInputStream(new File("./nl/tests/println3.nl"))));
        System.out.print(eval2);
    }
}
