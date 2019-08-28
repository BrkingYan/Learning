package Mr.Left.T5.use_stack_to_sort_stack;

import java.util.LinkedList;

/*
*  用一个栈去排序另一个栈
* */
public class Solution {

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }

    public static void sort(LinkedList<Integer> stack){
        LinkedList<Integer> helper = new LinkedList<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if (helper.isEmpty()){
                helper.push(cur);
            }else {
                if (cur <= helper.peek()){
                    helper.push(cur);
                }else {
                    while (!helper.isEmpty()){
                        stack.push(helper.pop());
                    }
                    helper.push(cur);
                }
            }
        }
        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
    }
}
