package LeetCode.LeetCode2.NK2;

import java.util.LinkedList;

class BackToIn {
    private LinkedList<String> stack;
    private LinkedList<String> result;
    public String backToIn(String[] tokens){
        stack = new LinkedList<>();
        boolean hasCurrent = false;
        result = new LinkedList<>();
        for (int i = 0;i<tokens.length;i++){
            if (isOperator(tokens[i])){
                if (!hasCurrent){
                    result.add(0,")");
                    result.add(0,stack.pop());
                    result.add(0,tokens[i]);
                    result.add(0,stack.pop());
                    result.add(0,"(");
                    hasCurrent = true;
                }else {
                    result.add(")");
                    result.add(0,tokens[i]);
                    result.add(0,stack.pop());
                    result.add(0,"(");
                }

            }else {
                stack.push(tokens[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : result){
            sb.append(s);
        }
        return sb.toString();
    }

    private boolean isOperator(String s){
        if (s.equals("+") || s.equals("-")||s.equals("*") ||s.equals("/") ){
            return true;
        }
        return false;
    }
}
