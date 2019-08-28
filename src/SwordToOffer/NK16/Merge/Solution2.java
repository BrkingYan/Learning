package SwordToOffer.NK16.Merge;


/*
* 输入两个单调递增的链表，输出两个链表合成后的链表，
* 当然我们需要合成后的链表满足单调不减规则。
* */
class Solution2 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            if (list2 == null){
                return null;
            }else {
                return list2;
            }
        }else{
            if (list2 == null){
                return list1;
            }
        }
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode head;
        if (list1.val <= list2.val){
            head = list1;
            current1 = current1.next;
        }else {
            head = list2;
            current2 = current2.next;
        }
        ListNode current = head;
        while (current1 != null || current2 != null){
            if (current1 == null){
                current.next = current2;
                break;
            }
            if (current2 == null){
                current.next = current1;
                break;
            }
            if (current1.val <= current2.val){
                current.next = current1;
                current1 = current1.next;
            }else {
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }
        return head;
    }
}
