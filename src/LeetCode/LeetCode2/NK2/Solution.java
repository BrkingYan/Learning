package LeetCode.LeetCode2.NK2;

import java.util.LinkedList;

/*
* 后序表达式
* ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
* */
class Solution {
    private LinkedList<String> stack;
    public int evalRPN(String[] tokens) {
        String numToBeOp;
        String numToOp;
        int currentResult = 0;
        stack = new LinkedList<>();
        for (int i = 0;i<tokens.length;i++){
            if (isOperator(tokens[i])){
                numToBeOp = stack.pop();
                numToOp = stack.pop();
                currentResult = cal(numToOp,numToBeOp,tokens[i]);
                stack.push(String.valueOf(currentResult));
            }else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String s){
        if (s.equals("+") || s.equals("-")||s.equals("*") ||s.equals("/") ){
            return true;
        }
        return false;
    }

    private int cal(String a,String b,String op){
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        switch (op){
            case "+":return (aa+bb);
            case "-":return (aa-bb);
            case "*":return (aa*bb);
            case "/":return (aa/bb);
        }
        return 0;
    }

}
