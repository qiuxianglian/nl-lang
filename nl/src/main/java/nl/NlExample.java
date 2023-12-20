package nl;


import java.io.*;

public class NlExample {

    public static void main(String[] args) throws Exception {
        NLLang nlLang = new NLLang();
        Object eval = nlLang.eval(new InputStreamReader((new ByteArrayInputStream("1+1".getBytes()))));
        System.out.println(eval);
    }
}
