package ForTest.LinkedList;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args){
        LinkedNode ln = new LinkedNode(5);
        ln.next = new LinkedNode(4);
        System.out.println(ln.val);
        System.out.println(ln.next.val);
    }
}
