package SwordToOffer.NK20.stackContainsMin;


/*
*定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
* */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private List<Integer> backUpList = new ArrayList<>();
    private int min;
    private int minBackUp;
    private Stack<Integer> stack;
    public void push(int node) {
        if (stack.isEmpty()){
            min = node;
            minBackUp = node;
            backUpList.add(minBackUp);
        }else {
            if (node < min){
                if (node < minBackUp){
                    minBackUp = min;
                    min = node;
                }
                min = node;
            }else if (node < minBackUp){
                minBackUp = node;
                backUpList.add(minBackUp);
            }
        }
        stack.push(node);
    }

    public void pop() {
        if (top() == min || top() == minBackUp){
            min = minBackUp;
            backUpList.remove(backUpList.size()-1);
            minBackUp = backUpList.get(backUpList.size()-1);
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    //该函数能够得到栈中最小元素
    public int min() {
        return min;
    }
}