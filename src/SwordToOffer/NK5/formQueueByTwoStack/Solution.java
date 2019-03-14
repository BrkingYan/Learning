package SwordToOffer.NK5.formQueueByTwoStack;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();//负责出队
    Stack<Integer> stack2 = new Stack<Integer>();
    int length = 0;

    public void push(int node) {
        stack2.push(node);
        length ++;
    }

    public int pop() {
        for (int i = length;i > 0;i--){
            stack1.push(stack2.pop());
        }
        int node = stack1.peek();
        stack1.pop();//丢弃栈顶元素
        length--;
        for (int i = length;i > 0;i--){
            stack2.push(stack1.pop());
        }
        return node;
    }
}