package LeetCode._1.AddTwoNumbers;

public class Test {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        System.out.print(l1.val);
        System.out.print(l1.next.val);
        System.out.print(l1.next.next.val);

        System.out.println();

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        System.out.print(l2.val);
        System.out.print(l2.next.val);
        System.out.print(l2.next.next.val);

        System.out.println();

        Solution s = new Solution();

        ListNode l3 = s.addTwoNumbers(l1,l2);
        System.out.print(l3.val);
        System.out.print(l3.next.val);
        System.out.print(l3.next.next.val);
        System.out.print(l3.next.next.next.val);

    }

}
