package nl;



public class NLContext {
    private final NLLang language;


    public NLContext(NLLang language) {
        this.language = language;
    }

    public NLLang getLanguage() {
        return language;
    }

}
