
open module nl {
  requires java.base;
  requires java.logging;
  requires jdk.unsupported;
  requires org.antlr.antlr4.runtime;
  requires org.graalvm.polyglot;
  requires org.graalvm.truffle;
  provides  com.oracle.truffle.api.provider.TruffleLanguageProvider with
    nl.NLLangProvider;
  exports nl;
}
