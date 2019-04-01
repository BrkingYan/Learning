package dataStructure2.Stack.InFix;

import java.util.ArrayList;
import java.util.List;

class Stack<T> {
    List<T> list;
    int size;

    Stack(){
        list = new ArrayList<>();
        size = 0;
    }

    void push(T num){
        list.add(num);
        size++;
    }

    T pop(){
        T temp  = list.remove(size-1);
        size--;
        return temp;
    }

    T peek(){
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
