package MI_OJ;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(2);
        new Test().insertionSortList(head);
    }
    private static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(1);
        pre.next = head;
        //ListNode cur = head;
        while(head != null){
            ListNode curHead = pre.next;//当前头节点
            if(head == curHead){
                head = head.next;
                continue;
            }
            ListNode preCur = pre;
            while(preCur != null){
                if(preCur.next != null && preCur.next.val > head.val){
                    ListNode temp = head.next;
                    head.next = preCur.next;
                    preCur.next = head;

                    continue;
                }
                preCur = preCur.next;
            }
            head = head.next;
        }
        return pre.next;
    }
}
