package Mr.Left.T24.hui_wen_link_list;

import java.util.LinkedList;

/*
*  判断一个链表是否是回文的
* */
public class Solution {
    private static class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    public static boolean solution(Node head){
        LinkedList<Integer> stack = new LinkedList<>();
        Node cur = head;
        int n = 0;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        Node midEnd;
        int midEndd = 0;
        Node midStart;
        midEndd = n / 2;

        cur = head;
        int count = 0;
        while (count < midEndd-1){
            stack.push(cur.val);
            cur = cur.next;
            count++;
        }
        midEnd = cur;
        if (n % 2 == 0){
            midStart = midEnd.next;
        }else {
            midStart = midEnd.next.next;
        }
        cur = midStart;
        while (cur != null){
            if (stack.isEmpty()){
                return false;
            }
            if (stack.pop() != cur.val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(solution(head));
    }
}
