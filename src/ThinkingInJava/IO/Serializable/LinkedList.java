package ThinkingInJava.IO.Serializable;

import java.io.Serializable;
import java.util.Random;

class LinkedList implements Serializable {
    Node head;
    Random rand = new Random();

    LinkedList(char firstMarker,int length){
        head = new Node(firstMarker,rand.nextInt(10),length);
    }

    public String toString(){
        Node current = head;
        StringBuilder sb = new StringBuilder();
        sb.append(current);
        while (current.next != null){
            sb.append(current.next);
            current = current.next;
        }
        return sb.toString();
    }

    private class Node implements Serializable{
        int val;
        char headMarker;
        Node next;
        Node(char headMarker,int val,int length){
            this.val = val;
            this.headMarker = headMarker;
            length--;
            if (length > 0){
                next = new Node((char)(headMarker+1),rand.nextInt(10),length);
            }else {
                next = null;
            }

        }

        Node(char headMarker,int val){
            this.headMarker = headMarker;
            this.val = val;
        }

        public String toString(){
            if (next == null){
                return headMarker + "(" + val + ")";
            }
            return headMarker + "(" + val + ") -> ";
        }
    }
}
