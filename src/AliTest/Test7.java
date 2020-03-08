package AliTest;

import java.util.*;

class Test7 {

    private HashMap<Integer,Node> map = new HashMap<>();
    private MyList list = new MyList();
    private int cap;
    public Test7(int capacity) {
        this.cap = capacity;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            list.moveToFirst(cur);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node cur = new Node(key,value);
        list.addFirst(cur);
        map.put(key,cur);
        if(list.size() > cap){
            int k = list.removeLast();
            map.remove(k);
        }
    }

    private class MyList{
        Node head = new Node(1,1);
        Node tail = new Node(-1,-1);
        int size;

        MyList(){
            head.next = tail;
            head.pre = null;
            tail.pre = head;
            tail.next = null;
        }

        int size(){
            return size;
        }

        void addFirst(Node node){
            Node second = head.next;
            head.next = node;
            node.pre = head;
            node.next = second;
            second.pre = node;
            size++;
        }

        int removeLast(){
            Node toRemove = tail.pre;
            Node pre = toRemove.pre;
            pre.next = tail;
            tail.pre = pre;
            int ret = toRemove.val;
            size--;
            return toRemove.key;
        }

        void moveToFirst(Node node){
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;

            Node second = head.next;
            node.next = second;
            second.pre = node;
            head.next = node;
            node.pre = head;
        }
    }

    private class Node{
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
