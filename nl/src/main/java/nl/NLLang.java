package nl;


import nl.node.Lang;
import nl.node.Node;
import nl.parser.NlParser;

import java.io.InputStreamReader;


public class NLLang extends Lang {
    public final static String ID = "nl";
    public NLLang() {
    }


    public Node parse(String request) throws Exception {
        String source = request;
        Node node = NlParser.parseNL(this,source);
        return node;
    }

    public Object eval(InputStreamReader source){
        return null;
    }

}
