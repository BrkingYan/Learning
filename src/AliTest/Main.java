package AliTest;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        String a = "(5+5)*2-(4-2)/2";
        char [] x = a.toCharArray();
        Stack<Character> stack = new Stack<>();

        String post = toPost(x,stack);

        Stack<Double> bb = new Stack<>();
        double p,q;
        char [] xx = post.toCharArray();
        for (int i = 0; i < xx.length; i++) {
            if(xx[i] >= '0' && xx[i] <= '9') {
                double s = (double) xx[i] - 48;
                //System.out.println(s);
                bb.push(s);
                //System.out.println(xx[i] - 48);
            }
            if(xx[i] == '+'){
                p = bb.peek();
                bb.pop();
                q = bb.peek();
                bb.pop();
                double result = p+q;
                bb.push(result);
                //System.out.println(result);
            }
            if(xx[i] == '-'){
                p = bb.peek();
                bb.pop();
                q = bb.peek();
                bb.pop();
                double result = q-p;
                bb.push(result);
                //System.out.println(result);
            }
            if(xx[i] == '*'){
                p = bb.peek();
                bb.pop();
                q = bb.peek();
                bb.pop();
                double result = p*q;
                bb.push(result);
                //System.out.println(result);
            }
            if(xx[i] == '/'){
                p = bb.peek();
                bb.pop();
                q = bb.peek();
                bb.pop();
                double result = q/p;
                bb.push(result);
                //System.out.println(result);
            }
        }
        int aaa = bb.peek().intValue();
        System.out.println(aaa);
    }

    private static String toPost(char[] x,Stack<Character> b){
        StringBuilder post = new StringBuilder();
        for (int i = 0; i <x.length; i++) {
            //System.out.println(back);
            if(x[i] == '(') b.push(x[i]);
            if(x[i] == '+' || x[i] == '-') {
                while(!b.isEmpty() && (b.peek() == '*' || b.peek() == '/')) {
                    post.append(b.peek());
                    b.pop();
                }
                b.push(x[i]);
            }
            if(x[i] == '*' || x[i] == '/') {
                while(!b.isEmpty() && (b.peek() == '*' || b.peek() == '/')) {
                    post.append(b.peek());
                    b.pop();
                }
                b.push(x[i]);
            }
            if(x[i] == ')') {
                while (!b.isEmpty()){
                    if(b.peek() == '(') {b.pop(); break;}
                    //System.out.println(back);
                    post.append(b.peek());
                    b.pop();
                }
            }
            if(x[i] >= '0' && x[i] <= '9') {
                post.append(x[i]);
            }
        }
        while(!b.isEmpty()){
            post.append(b.pop());
        }
        return post.toString();
    }
}
