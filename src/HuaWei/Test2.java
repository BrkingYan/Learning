package HuaWei;

import java.util.*;

//  ‰»Î abc3(A)  b2(A)a2[b3(C)]a
//  ‰≥ˆ AAAcba   aCCCbCCCbaAAb
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        char[] chars = expression.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0;i<chars.length;i++){
             stack.push(chars[i]);
        }
        LinkedList<Character> tempStack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        while (!stack.isEmpty()){
            char ch = stack.pop();
            switch (ch){
                case '}':
                    break;
                case ']':
                    if (!tempStack.isEmpty()){
                        result.append(tempStack.pop());
                    }
                    break;
                case ')':
                    break;
                case '(':
                    char times = stack.pop();
                    char ch2 = tempStack.pop();
                    for (int i = 0;i<Integer.parseInt(times+"");i++){
                        result.append(ch2);
                    }
                    break;
                case '[':
                    while (!tempStack.isEmpty()){
                        result.append(tempStack.pop());
                    }
                    char times2 = stack.pop();
                    for (int i = 0;i<Integer.parseInt(times2+"")-1;i++){
                        result.append(temp);
                    }
                    break;
                case '{':
                    while (!tempStack.isEmpty()){
                        temp.append(tempStack.pop());
                    }
                    char times3 = stack.pop();
                    for (int i = 0;i<Integer.parseInt(times3+"")-1;i++){
                        temp.append(temp);
                    }
                    break;
                default:
                    tempStack.push(ch);
                    break;
            }
        }
        if (! tempStack.isEmpty()){
            for (int i = tempStack.size()-1;i>=0;i--){
                temp.append(tempStack.get(i));
            }
        }
        System.out.print(temp.toString());
    }
}
