package methodTest;


import java.util.*;
public class Solution{
    private static class Node{
        Node next = null;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        String[] ss = s.split(" ");
        Node head = new Node(Integer.parseInt(ss[0]));
        Node cur = head;
        for(int i = 1;i<ss.length;i++){
            cur.next = new Node(Integer.parseInt(ss[i]));
            cur = cur.next;
        }
        Node newHead = reverseList(head,k);
        StringBuilder ret = new StringBuilder();
        cur = newHead;
        while(cur != null){
            ret.append(cur.val);
            ret.append(" ");
            cur = cur.next;
        }
        System.out.println(ret.toString());
    }
    private static Node reverseList(Node head,int k){
        Node cur = head;
        Node totalPre = new Node(-1);
        Node pre = totalPre;
        pre.next = head;

        Node curTail;
        Node nextSegHead;
        while (getLength(cur) >= k){
            curTail = cur;
            for(int i = 0;i<k-1;i++){
                curTail = curTail.next;
            }
            nextSegHead = curTail.next;
            curTail.next = null;
            pre.next = reverse(cur,nextSegHead);
            pre = cur;
            cur = cur.next;
        }
        return totalPre.next;
    }

    private static Node reverse(Node head,Node next){
        Node cur = head;
        Node temp = cur;
        Node before = null;
        while(cur != null){
            cur = cur.next;
            temp.next = before;
            before = temp;
            temp = cur;
        }
        if(head != null){
            head.next = next;
        }
        return before;
    }

    private static int getLength(Node node){
        if(node == null){
            return 0;
        }
        Node cur = node;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        char[] chs = new char[]{'1'};

        return count;
    }
}
