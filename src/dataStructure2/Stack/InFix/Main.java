package dataStructure2.Stack.InFix;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operator plus = new Operator('+',0);
        Operator minus = new Operator('-',0);
        Operator multiply = new Operator('*',1);
        Operator divide = new Operator('/',1);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        System.out.println("请输入表达式 : ");
        while (count > 0){
            sb.append(sc.nextLine());
            count--;
        }
        char[] array = sb.toString().toCharArray();

        Stack<Character> charStack = new Stack();
        Stack<Character> numStack = new Stack();
        int chValue;
        for (int i = 0;i<array.length;i++){
            if (i % 2 == 1){
                if (charStack.isEmpty()){
                    charStack.push(array[i]);
                }else {
                    if (shouldOperate(array[i],charStack.peek())){

                    }
                }
            }else {
                numStack.push(array[i]);
            }
        }

    }

    private static boolean shouldOperate(char ch,char peek){
        if (peek == '*' || peek == '/'){
            return false;
        }
        if (ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }
}
