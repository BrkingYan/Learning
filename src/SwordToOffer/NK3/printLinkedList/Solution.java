package SwordToOffer.NK3.printLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> reverseList = new ArrayList<Integer>();
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = list.size() - 1;i >= 0;i--){
            reverseList.add(list.get(i));
        }
        return reverseList;
    }
}
