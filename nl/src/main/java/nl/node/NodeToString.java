package nl.node;

import java.util.*;
import java.util.stream.Collectors;

public class NodeToString implements VisitorAdapter<String>{

    private int tab  = 0;
    private String tabString(){
        return "  ".repeat(Math.max(0, tab));
    }

    public static String nodeToString(Node node){
        return new NodeToString().visit(node);
    }


    @Override
    public String visitNav(Nav node) {
        return tabString()+"-"+visit(node.getTarget());
    }

    @Override
    public String visitReciprocal(Reciprocal node) {
        return tabString()+"1/"+visit(node.getTarget());
    }


    @Override
    public String visitAddExpression(AddExpression addExpression) {
        return visit(addExpression.getLeft())+"+"+visit(addExpression.getRight());
    }

    @Override
    public String visitArrayNode(ArrayNode arrayNode) {
        ArrayList<Object> list = new ArrayList<>(arrayNode.getNodes().keySet().size());
        List<Object> others = new ArrayList<>();
        for (Object o : arrayNode.getNodes().keySet()) {
            try {
                int i = Integer.parseInt("" + o);
                list.add(i);
            }catch (Exception e){
                others.add(o);
            }
        }
        list.sort(Comparator.comparingInt(a -> ((Integer) a)));
        list.addAll(others);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            Object arrVal = arrayNode.getNodes().get("" + o);
            if(arrVal instanceof Node nn){
                sb.append(visit(nn));
            }else{
                sb.append(arrVal);
            }

            if(i != list.size()-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String visitAssignExpression(AssignExpression assignExpression) {
        return visit(assignExpression.getId())+"="+visit(assignExpression.getExpression());
    }


    @Override
    public String visitBlockNode(BlockNode blockNode) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(tabString());
        sb.append("{\n");
        tab++;
        if(blockNode.getStatements() instanceof Statements||blockNode.getStatements() instanceof Statement){
            sb.append(visit(blockNode.getStatements()));
        }else{
            sb.append(tabString());
            sb.append(visit(blockNode.getStatements()));
        }
        tab--;
        sb.append("\n");
        sb.append(tabString());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String visitBooleanExpression(BooleanExpression booleanExpression) {
        return booleanExpression.isBool()+"";
    }

    @Override
    public String visitBreakNode(BreakNode breakNode) {
        return "break";
    }

    @Override
    public String visitCallExpression(CallExpression callExpression) {
        StringBuilder sb = new StringBuilder();
        if(callExpression.getFunctionExpression() instanceof IdExpression){
            sb.append(visit(callExpression.getFunctionExpression()));
        }else{
            sb.append("\n");
            sb.append(tabString()+"(");
            tab++;

            sb.append(visit(callExpression.getFunctionExpression()));
            sb.append("\n");
            tab--;
            sb.append(tabString());
            sb.append(")");
        }
        sb.append("("+Arrays.stream(callExpression.getInputs()).map(this::visit).collect(Collectors.joining(","))+")");
        return sb.toString();
    }



    @Override
    public String visitContinueNode(ContinueNode continueNode) {
        return "continue";
    }

    @Override
    public String visitDevExpression(DevExpression devExpression) {
        return visit(devExpression.getLeft())+"/"+visit(devExpression.getRight());
    }

    @Override
    public String visitEuqalExpression(EuqalExpression euqalExpression) {
        return visit(euqalExpression.getLeft())+"=="+visit(euqalExpression.getRight());
    }


    @Override
    public String visitFunctionExpression(FunctionExpression functionExpression) {
        StringBuffer sb = new StringBuffer();
        sb.append("("+functionExpression.getIdExpressions().stream().map(this::visit).collect(Collectors.joining(","))+")"
                + "=>") ;

        if(functionExpression.getBody() instanceof BlockNode){
            tab++;
            sb.append(visit(functionExpression.getBody()));
            tab--;

        }else{
            sb.append(visit(functionExpression.getBody()));
        }
        return sb.toString();
    }

    @Override
    public String visitIdExpression(IdExpression idExpression) {
        return idExpression.getId();
    }

    @Override
    public String visitIfNode(IfNode ifNode) {
        StringBuilder sb = new StringBuilder();
        sb.append("if(");
        sb.append(visit(ifNode.getCondition()));
        sb.append(")");
        sb.append(visit(ifNode.getBody()));
        if(ifNode.getElseBody()!=null){
            sb.append("else");
            sb.append(visit(ifNode.getElseBody()));
        }
        return sb.toString();
    }

    @Override
    public String visitLessThanAndEqualExpression(LessThanAndEqualExpression lessThanAndEqualExpression) {
        return visit(lessThanAndEqualExpression.getLeft())+"<="+visit(lessThanAndEqualExpression.getRight());
    }

    @Override
    public String visitLessThanExpression(LessThanExpression lessThanExpression) {
        return visit(lessThanExpression.getLeft())+"<"+visit(lessThanExpression.getRight());
    }

    @Override
    public String visitMoreThanAndEqualExpression(MoreThanAndEqualExpression moreThanAndEqualExpression) {
        return visit(moreThanAndEqualExpression.getLeft())+">="+visit(moreThanAndEqualExpression.getRight());
    }

    @Override
    public String visitMoreThanExpression(MoreThanExpression moreThanExpression) {
        return visit(moreThanExpression.getLeft())+">"+visit(moreThanExpression.getRight());
    }

    @Override
    public String visitMulExpression(MulExpression mulExpression) {
        return visit(mulExpression.getLeft())+"*"+visit(mulExpression.getRight());
    }

    @Override
    public String visitNotEuqalExpression(NotEuqalExpression notEuqalExpression) {
        return visit(notEuqalExpression.getLeft())+"!="+visit(notEuqalExpression.getRight());
    }

    @Override
    public String visitNull(Null nullNode) {
        return tabString()+"null";
    }



    @Override
    public String visitNumberExpression(NumberExpression numberExpression) {
        return numberExpression.getNum()+"";
    }

    @Override
    public String visitObjectNode(ObjectNode objectNode) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int i = 0;
        for (Map.Entry<String, Object> stringObjectEntry : objectNode.getNodes().entrySet()) {
            String key = stringObjectEntry.getKey();
            Object value = stringObjectEntry.getValue();
            if(value instanceof Node nn){
                value = this.visit(nn);
            }
            sb.append(key).append(":").append(value);
            if(i!=objectNode.getNodes().size()-1){
                sb.append(",");
            }
        }
        sb.append("}");
        return tabString()+sb.toString();
    }

    @Override
    public String visitReturnNode(ReturnNode returnNode) {
        String res = ("return ");
        tab++;
        res = res + visit(returnNode.getValue());
        tab--;
        return res;
    }

    @Override
    public String visitRootEnter(RootEnter rootEnter) {
        return visit(rootEnter.getNode());
    }

    @Override
    public String visitStatement(Statement statement) {
        String res =  tabString() +visit(statement.getNode());
        if(!(statement.getNode() instanceof BlockNode)){
            res += ";";
        }
        return res;
    }

    @Override
    public String visitStatements(Statements statements) {
        return statements.getStatements().stream().map(this::visit).collect(Collectors.joining("\n"));
    }

    @Override
    public String visitStringExpression(StringExpression stringExpression) {
        return "\\\\'"+stringExpression.getStr().replaceAll("'","\\\\'")+"\\\\'";
    }

    @Override
    public String visitSubExpression(SubExpression subExpression) {
        return visit(subExpression.getLeft())+"-"+visit(subExpression.getRight());
    }



    @Override
    public String visitUndefinedNode(UndefinedNode undefinedNode) {
        return visit(undefinedNode.getNode())+"";
    }

    @Override
    public String visitValueNode(ValueNode valueNode) {
        Object value = valueNode.getValue();
        if(value instanceof Node nn){
            return visit(nn);

        }
        return value+"";
    }

    @Override
    public String visitWhileNode(WhileNode whileNode) {
        StringBuffer sb = new StringBuffer();
        sb.append("while(");
        sb.append(visit(whileNode.getCondition()));
        sb.append(")");
        sb.append(visit(whileNode.getBody()));
        return sb.toString();
    }
}
