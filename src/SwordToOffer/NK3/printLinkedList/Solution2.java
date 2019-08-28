package SwordToOffer.NK3.printLinkedList;

import java.util.ArrayList;

/*
* 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
* */
public class Solution2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode current = listNode;
        while (current != null){
            list.add(0,current.val);
            current = current.next;
        }
        return list;
    }
}
