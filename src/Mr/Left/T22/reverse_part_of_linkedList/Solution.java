package Mr.Left.T22.reverse_part_of_linkedList;


public class Solution {
    private static class Node{
        Node next;
        int val;

        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        reversePartList(head,2,4);
        //reverse(head);
    }

    /*
    *  1 <= from <= to <= n
    * */
    private static Node reversePartList(Node head,int from,int to){
        Node cur = head;
        int n = 0;

        Node before = null;
        Node after = null;

        while (cur != null){
            n++;
            if (n == from-1){
                before = cur;
            }
            if (n == to){
                after = cur.next;
            }
            cur = cur.next;
        }
        cur = head;
        before.next = reverse(before.next,after);
        while (cur != null){
            if (cur.next == null){
                cur.next = after;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    private static Node reverse(Node head,Node tail){
        Node before = null;
        Node cur = head;
        Node temp = cur;
        while (cur != tail){
            cur = cur.next;
            temp.next = before;
            before = temp;
            temp = cur;
        }
         cur = before;
        while (cur != null){
            if (cur.next == null){
                cur.next = tail;
                break;
            }
            cur = cur.next;
        }
        return before;
    }

    private static Node reverse(Node head){
        Node before = null;
        Node cur = head;
        Node temp = cur;
        while (cur != null){
            cur = cur.next;
            temp.next = before;
            before = temp;
            temp = cur;
        }
        return before;
    }
}
