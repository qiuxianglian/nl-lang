package nl;

import nl.builtin.BuiltIn;
import nl.node.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmalStepNLLangRunner implements NLLangRunner {
    @Override
    public Object eval(Lang lang, Node node) {
        NLScope.NLScopeOperator scope = NLScope.NLScopeOperator.newScope();
        BuiltIn.install(lang,scope.getScope());
        VirtualFrame instance = VirtualFrame.getFrameCache().getInstance();
        instance.setScopeOperator(scope);
        Node currentNode = node;
        int i = 0;
        List<Integer> length = new ArrayList<>();
        if(lang.isDebug()){
            lang.printStream().println("////////////////初始////////////////");
            lang.printStream().println(NodeToString.nodeToString(currentNode));
        }
        while (currentNode.reducible()) {
            Object reduce = currentNode.reduce(instance);
            String x = NodeToString.nodeToString(currentNode);
            if (reduce instanceof Node rNode) {
                currentNode = rNode;
                length.add(x.length());
                if(lang.isDebug()){
                    lang.printStream().println("////////////////第"+i+"步,表达式长"+x.length()+"////////////////");
                    lang.printStream().println(x);
                }
            } else {
                return null;
            }
            i++;
        }
        if(lang.isDebug()){
            lang.printStream().println("////////////////结束////////////////");

            double max = (double)length.stream().max(Comparator.comparingInt(o -> o)).orElse(0);

            int groupSize;
            if(length.size()>100){
                groupSize = (int) (((double)length.size())/100);
            }else{
                groupSize = 1;
            }
            for (int j = 0; j < length.size(); j+=groupSize) {
                double sumMax = 0;
                double sum = 0;
                int avgCnt = 0;
                for (int jj = 0; jj < j+groupSize; jj++) {
                    int u = (j+jj);
                    if(u < length.size()){
                        sumMax = Math.max(length.get(u),sumMax);
                        sum+=length.get(u);
                        avgCnt++;
                    }
                }
                int len = (int) ((sumMax+(sum/avgCnt))/1.5);

                lang.printStream().print("//"+j+" to "+(j+groupSize-1)+"\t");
                int p = (int) ((len/max)*100);
                for (int integer = 0; integer < p; integer++) {
                    lang.printStream().print("*");
                }
                lang.printStream().println();
            }
        }
        VirtualFrame.getFrameCache().cyl(instance);
        if(currentNode instanceof ValueNode vn){
            return vn.getValue();
        }
        return currentNode;
    }
}
