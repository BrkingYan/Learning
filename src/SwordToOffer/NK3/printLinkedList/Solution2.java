package SwordToOffer.NK3.printLinkedList;

import java.util.ArrayList;

/*
* ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
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
