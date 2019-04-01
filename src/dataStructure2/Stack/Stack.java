package dataStructure2.Stack;


import java.util.ArrayList;
import java.util.List;

class Stack {
    List<Integer> list;
    int size;

    Stack(){
        list = new ArrayList<>();
        size = 0;
    }

    void push(int num){
        list.add(num);
        size++;
    }

    int pop(){
        int temp  = list.remove(size-1);
        size--;
        return temp;
    }

    int peek(){
        return list.get(size-1);
    }

    boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
