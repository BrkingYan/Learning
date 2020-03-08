package Mr.Left.T1.getMin_Stack;

import java.util.LinkedList;

public class MyStack {
    private LinkedList<Integer> stackData = new LinkedList<>();
    private LinkedList<Integer> stackMin = new LinkedList<>();

    public int pop(){
        int temp = stackData.pop();
        if (getMin() == temp){
            stackMin.pop();
        }
        return temp;
    }

    public void push(int newNum){
        if (stackMin.isEmpty()){
            stackMin.push(newNum);
        }else {
            if (newNum <= getMin()){
                stackMin.push(newNum);
            }
        }
        stackData.push(newNum);
    }

    public int getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return stackMin.peek();
    }
}
