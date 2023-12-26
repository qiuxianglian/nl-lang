package nl;


import nl.node.Lang;
import nl.node.Node;
import nl.parser.NlParser;

import java.io.InputStreamReader;


public class NLLang extends Lang {
    public final static String ID = "nl";

    public NLLang() {
    }


    public Node parse(InputStreamReader request) throws Exception {
        Node node = NlParser.parseNL(this,request);
        return node;
    }

    public Object eval(InputStreamReader source) throws Exception {
//        try {
            Node parse = parse(source);
            NLLangRunner dfsnlLangRunner = new SmalStepNLLangRunner();//new DFSNLLangRunner();
            return dfsnlLangRunner.eval(this,parse);
//        } catch (Error e){
//            throw new NLException(e.getClass().getName());
//        }
    }

}
