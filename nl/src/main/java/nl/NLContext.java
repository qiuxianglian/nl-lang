package nl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;

public class NLContext {
    private final NLLang language;
    @CompilerDirectives.CompilationFinal
    private TruffleLanguage.Env env;

    public NLContext(NLLang language, TruffleLanguage.Env env) {
        this.language = language;
        this.env = env;
    }

    public NLLang getLanguage() {
        return language;
    }

    public TruffleLanguage.Env getEnv() {
        return env;
    }
}
