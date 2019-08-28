package Mr.Left.T3.recur_form_stack_reverse;

import java.util.LinkedList;

/*
* 如何仅用递归函数和栈操作(push、pop、peek)完成一个栈的逆序
* */
public class Solution {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
    public static void reverse(LinkedList<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
            int bottom = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(bottom);

    }

    //获取并移除栈底元素
    private static int getAndRemoveLastElement(LinkedList<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int bottom = getAndRemoveLastElement(stack);
            stack.push(result);
            return bottom;
        }
    }
}
