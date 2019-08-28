package ForTest;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MyQueue<E> implements Iterable {
    private Object[] arr;
    private int size;
    private int modCount;
    private final int DEFAULT_CAP = 16;

    public MyQueue(){
        arr = new Object[DEFAULT_CAP];
        size = 0;
        modCount = 0;
    }

    public boolean add(E newVal){
        if (newVal == null){
            throw new NullPointerException();
        }
        int i = size;
        if (i >= arr.length){
            grow();
        }
        arr[i] = newVal;
        size++;
        modCount++;
        return true;
    }

    public int size(){
        return size;
    }

    public E poll(){
        E ret = (E)arr[0];
        for (int i = 0;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        size--;
        modCount++;
        return ret;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void grow(){
        int oldCap = arr.length;
        int newCap = oldCap + (oldCap >> 1);
        arr = Arrays.copyOf(arr,newCap);
    }


    @Override
    public Iterator iterator() {
        return new MyItr();
    }

    private class MyItr implements Iterator {
        int start = 0;
        @Override
        public boolean hasNext() {
            return start < size;
        }

        @Override
        public Object next() {
            return arr[start++];
        }
    }
}
