package AliTest;

import java.util.LinkedList;

public class Test2 {
    public static void main(String[] args) {
        String input = "(1+2)*3+4=";
        char[] expression = new char[input.length() - 1];
        for (int i = 0; i < input.length() - 1; i++) {
            expression[i] = input.charAt(i);
        }

        LinkedList<Character> stack = new LinkedList<>();
        char[] post = toPost(expression, stack).toCharArray();
        System.out.println(calPost(post));
    }

    //将字符串转化为后缀表达式
    private static String toPost(char[] x, LinkedList<Character> stack) {
        StringBuilder post = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            if (x[i] == '(') {
                stack.push(x[i]);
            }
            if (x[i] == '+' || x[i] == '-') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    post.append(stack.peek());
                    stack.pop();
                }
                stack.push(x[i]);
            }
            if (x[i] == '*' || x[i] == '/') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    post.append(stack.peek());
                    stack.pop();
                }
                stack.push(x[i]);
            }
            if (x[i] == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    post.append(stack.peek());
                    stack.pop();
                }
            }
            if (x[i] >= '0' && x[i] <= '9') {
                post.append(x[i]);
            }
        }
        while (!stack.isEmpty()) {
            post.append(stack.pop());
        }
        return post.toString();
    }

    //计算后缀表达式
    private static int calPost(char[] post){
        LinkedList<Double> stack = new LinkedList<>();
        double p,q;
        for (int i = 0; i < post.length; i++) {
            if(post[i] >= '0' && post[i] <= '9') {
                double s = (double) post[i] - '0';
                stack.push(s);
            }
            if(post[i] == '+'){
                p = stack.peek();
                stack.pop();
                q = stack.peek();
                stack.pop();
                double result = p+q;
                stack.push(result);
            }
            if(post[i] == '-'){
                p = stack.peek();
                stack.pop();
                q = stack.peek();
                stack.pop();
                double result = q-p;
                stack.push(result);
            }
            if(post[i] == '*'){
                p = stack.peek();
                stack.pop();
                q = stack.peek();
                stack.pop();
                double result = p*q;
                stack.push(result);
            }
            if(post[i] == '/'){
                p = stack.peek();
                stack.pop();
                q = stack.peek();
                stack.pop();
                double result = q/p;
                stack.push(result);
                //System.out.println(result);
            }
        }
        int aaa = stack.peek().intValue();
        return aaa;
    }
}
