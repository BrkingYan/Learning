package SwordToOffer.NK15.ReverseList;
/*
* 输入一个链表，反转链表后，输出新链表的表头。
* */

import java.util.ArrayList;
import java.util.List;

class Solution {
    private ListNode currentHead;
    private ListNode newHead;
    private ListNode currentTail;
    private int length = 1;
    private List<Integer> list = new ArrayList<>();
    public ListNode ReverseList(ListNode head) {
       if (head == null){
           return null;
       }else {
           currentHead = head;
           /*System.out.println(currentHead.next);
           System.out.println(currentHead.next.next);*/
            //计算链表的节点数目
           while (currentHead.next != null){
               list.add(currentHead.val);
               currentHead = currentHead.next;
               length ++;
           }
           newHead = currentHead;
           currentTail = newHead;
           for (int i = 0;i < length - 1;i ++){
               currentTail.next = new ListNode(list.get(length-2-i));
               currentTail = currentTail.next;
           }
           currentTail.next = null;
       }
       return newHead;
    }
}
