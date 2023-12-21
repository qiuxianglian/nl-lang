package nl.builtin;

import nl.NLScope;
import nl.node.Lang;

import java.util.ArrayList;

public class BuiltIn {
    public static void install(Lang lang, NLScope scope) {
        scope.put("println", new Println(lang, new ArrayList<>()));
        scope.put("print", new Print(lang, new ArrayList<>()));
    }
}
