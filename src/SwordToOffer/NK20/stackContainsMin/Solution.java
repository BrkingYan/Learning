package SwordToOffer.NK20.stackContainsMin;


/*
*定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
* */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()){
            minStack.push(node);
        }else {
            if (node <= minStack.peek()){
                minStack.push(node);
            }
        }

    }

    public void pop() {
        if (minStack.peek().equals(dataStack.pop())){
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}