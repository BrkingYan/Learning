package SwordToOffer.NK15.ReverseList;

/*
* 输入一个链表，反转链表后，输出新链表的表头。
* */
class Solution2 {
    public ListNode ReverseList(ListNode head) {
        ListNode before = null;
        ListNode current = head;
        ListNode temp = null;

        while (current != null){
            temp = current;
            current = current.next;
            temp.next = before;
            before = temp;
        }
        ListNode newHead = temp;
        return newHead;
    }
}
