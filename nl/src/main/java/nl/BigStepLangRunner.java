package nl;

import nl.builtin.BuiltIn;
import nl.node.Lang;
import nl.node.Node;
import nl.node.VirtualFrame;

public class BigStepLangRunner implements NLLangRunner{
    @Override
    public Object eval(Lang lang, Node node) {
        VirtualFrame frame = new VirtualFrame();
        NLScope.NLScopeOperator scope = NLScope.NLScopeOperator.newScope();
        frame.setScope(scope);
        BuiltIn.install(lang,scope.getScope());
        return node.execute(frame);
    }
}
