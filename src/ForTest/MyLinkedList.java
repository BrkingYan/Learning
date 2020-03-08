package ForTest;

import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;

public class MyLinkedList<E> {
    private class Node<E>{
        E val;
        Node next;
        Node pre;
        Node(E val){
            this.val = val;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public MyLinkedList(){
    }

    public boolean add(E val){
        if (val  == null){
            throw new NullPointerException();
        }
        if(head == null){
            head = new Node<>(val);
            tail = head;
            size++;
        }else{
            tail.next = new Node(val);
            tail.next.pre = tail;
            tail = tail.next;
            size++;
        }
        return true;
    }

    public int size(){
        return size;
    }

    public boolean remove(int idx){
        int cnt = idx;
        Node cur = head;
        while (cnt > 0){
            cur = cur.next;
            cnt--;
        }
        Node pre = cur.pre;
        if (cur == tail){
            pre.next = null;
            tail = pre;
        }else {
            pre.next = cur.next;
            cur.next.pre = pre;
        }
        size--;
        return true;
    }

    public E get(int index){
        if(index >= size){
            throw new NullPointerException();
        }
        int cnt = index;
        Node cur = head;
        while (cnt > 0){
            cur = cur.next;
            cnt--;
        }
        return (E) cur.val;
    }
}
