package SwordToOffer.NK56.deleteDuplication;

/*
 * ��һ������������У������ظ��Ľ�㣬
 * ��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return pHead;
        }

        if (pHead.val == pHead.next.val){
            ListNode temp = pHead.next;
            while (temp != null && temp.val == pHead.val){
                temp = temp.next;
            }
            return deleteDuplication(temp);
        }else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }

    }

}
