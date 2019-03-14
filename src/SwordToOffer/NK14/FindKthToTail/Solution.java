package SwordToOffer.NK14.FindKthToTail;

/*
* 输入一个链表，输出该链表中倒数第k个结点。
* */
class Solution {
    private ListNode currentNode;
    private ListNode tempNode;
    private int length = 1;
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }else {
            //计算链表的长度
            tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
                length ++;
            }
            if (length >= k){
                for (int i = 0;i < length - k ;i++){
                    head = head.next;
                }
                return head;
            }else {
                return null;
            }
        }

    }
}
