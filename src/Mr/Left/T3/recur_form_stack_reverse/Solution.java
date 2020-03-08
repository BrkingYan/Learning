package Mr.Left.T3.recur_form_stack_reverse;

import java.util.LinkedList;

/*
* ��ν��õݹ麯����ջ����(push��pop��peek)���һ��ջ������
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

    //��ȡ���Ƴ�ջ��Ԫ��
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
