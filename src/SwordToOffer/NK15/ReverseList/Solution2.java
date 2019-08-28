package SwordToOffer.NK15.ReverseList;

/*
* ����һ��������ת��������������ı�ͷ��
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
