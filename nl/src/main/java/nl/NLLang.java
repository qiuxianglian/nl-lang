package nl;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.nodes.ExecutableNode;
import com.oracle.truffle.api.source.Source;
import nl.node.Node;
import nl.parser.NlParser;

@TruffleLanguage.Registration(id = NLLang.ID, name = "NL", defaultMimeType = NLLang.MIME_TYPE, characterMimeTypes = NLLang.MIME_TYPE, contextPolicy = TruffleLanguage.ContextPolicy.SHARED, fileTypeDetectors = NLFileDetector.class, //
        website = "https://www.graalvm.org/graalvm-as-a-platform/implement-language/")
@ProvidedTags({StandardTags.CallTag.class, StandardTags.StatementTag.class, StandardTags.RootTag.class, StandardTags.RootBodyTag.class, StandardTags.ExpressionTag.class, DebuggerTags.AlwaysHalt.class,
        StandardTags.ReadVariableTag.class, StandardTags.WriteVariableTag.class})

public class NLLang extends TruffleLanguage<NLContext> {
    public final static String ID = "nl";
    public static final String MIME_TYPE = "application/x-sl";

    public NLLang() {
    }

    @Override
    protected NLContext createContext(Env env) {
        return new NLContext(this, env);
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        Node node = NlParser.parseNL(this,source);
        return node.getCallTarget();
    }


}
