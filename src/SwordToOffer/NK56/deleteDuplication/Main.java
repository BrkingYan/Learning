package SwordToOffer.NK56.deleteDuplication;

import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        //head.next.next.next = new ListNode(3);
        //head.next.next.next.next = new ListNode(3);
        //head.next.next.next.next.next = new ListNode(4);
        Solution s = new Solution();
        ListNode node = s.deleteDuplication(head);

        ListNode cur = node;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
