package Mr.Left.T26.Two_Sum;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Node h1 = new Node(9);
        h1.next = new Node(3);
        h1.next.next = new Node(7);

        Node h2 = new Node(6);
        h2.next = new Node(3);

        Node ret = add(h1,h2);
    }

    private static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    private static Node add(Node head1,Node head2){
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null){
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }

        int n1;
        int n2;
        int sum;
        Node newHead = null;
        Node pre = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = n1 + n2 + carry;
            if(sum >= 10){
                sum -= 10;
                carry = 1;
            }else {
                carry = 0;
            }
            if (newHead == null){
                newHead = new Node(sum);
                pre = null;
            }else {
                pre = newHead;
                newHead = new Node(sum);
                newHead.next = pre;
            }
        }
        if (carry == 1){
            pre = newHead;
            newHead = new Node(1);
            newHead.next = pre  ;
        }
        return newHead;
    }
}
