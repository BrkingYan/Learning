package Mr.Left.T27.reverse_per_k;

import java.util.LinkedList;

public class Solution {
    private static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    private static Node reversePerK(Node head,int k){
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = head;
        Node dummy = new Node(1);
        Node curr = dummy;
        while (cur != null){
            stack.push(cur);
            if (stack.size() == 3){
                cur = stack.peek().next;
                while (!stack.isEmpty()){
                    curr.next = stack.pop();
                    curr = curr.next;
                }
            }else {
                cur = cur.next;
            }
        }
        while (!stack.isEmpty()){
            curr.next = stack.pop();
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        reversePerK(head,3);
    }
}
