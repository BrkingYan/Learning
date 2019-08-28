package SwordToOffer.NK14.FindKthToTail;

//输入一个链表，输出该链表中倒数第k个结点。
public class Solution2 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }
        int len = 0;
        ListNode current = head;
        while (current != null){
            len ++;
            current = current.next;
        }
        if (k > len){
            return null;
        }

        ListNode cur = head;
        int n = len - k;
        while (n > 0){
            cur = cur.next;
            n--;
        }
        return cur;
    }
}
