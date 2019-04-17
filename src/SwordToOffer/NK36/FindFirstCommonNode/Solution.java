package SwordToOffer.NK36.FindFirstCommonNode;

import java.util.*;
/*
*  �������������ҳ����ǵĵ�һ��������㡣
* */
class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set1 = new HashSet<>();
        ListNode current1 = pHead1;
        while (current1 != null){
            set1.add(current1);
            current1 = current1.next;
        }

        ListNode current2 = pHead2;
        while (current2 != null){
            if (set1.contains(current2)){
                return current2;
            }
            current2 = current2.next;
        }
        return null;
    }
}
