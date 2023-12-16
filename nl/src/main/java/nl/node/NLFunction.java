//package nl.node;
//
//import com.oracle.truffle.api.RootCallTarget;
//import com.oracle.truffle.api.TruffleLanguage;
//import com.oracle.truffle.api.dsl.Cached;
//import com.oracle.truffle.api.dsl.ReportPolymorphism;
//import com.oracle.truffle.api.dsl.Specialization;
//import com.oracle.truffle.api.interop.InteropLibrary;
//import com.oracle.truffle.api.interop.TruffleObject;
//import com.oracle.truffle.api.library.ExportLibrary;
//import com.oracle.truffle.api.library.ExportMessage;
//import com.oracle.truffle.api.nodes.IndirectCallNode;
//import nl.NLLang;
//
//@ExportLibrary(InteropLibrary.class)
//@SuppressWarnings("static-method")
//
//public class NLFunction implements TruffleObject {
//
//
//    private RootCallTarget rootCallTarget;
//    private FunctionExpression functionExpression;
//
//
//
//    public NLFunction(FunctionExpression functionExpression,RootCallTarget rootCallTarget) {
//        this.rootCallTarget = rootCallTarget;
//        this.functionExpression = functionExpression;
//    }
//    @ExportMessage
//    boolean isExecutable() {
//        return true;
//    }
//
//
//
//    public RootCallTarget getRootCallTarget() {
//        return rootCallTarget;
//    }
//
//    @ExportMessage
//    boolean hasLanguage() {
//        return true;
//    }
//
//    @ExportMessage
//    Class<? extends TruffleLanguage<?>> getLanguage() {
//        return NLLang.class;
//    }
//
//    @ExportMessage final Object toDisplayString(boolean allowSideEffects) {
//        return "匿名函数";
//    }
//
//    @ReportPolymorphism
//    @ExportMessage
//    abstract static class Execute {
//
//        @Specialization()
//        protected static Object doIndirect(NLFunction function, Object[] arguments,
//                                           @Cached IndirectCallNode callNode) {
//            /*
//             * SL has a quite simple call lookup: just ask the function for the current call target,
//             * and call it.
//             */
//
//            return callNode.call(function.getRootCallTarget(), arguments);
//        }
//    }
//}
