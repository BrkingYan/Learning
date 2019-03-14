package SwordToOffer.NK16.Merge;


public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(2);

        ListNode node2 = solution.Merge(node,node1);

        /*System.out.println(node2.val);
        System.out.println(node2.next.val);
        System.out.println(node2.next.next.val);
        System.out.println(node2.next.next.next.val);
        System.out.println(node2.next.next.next.next.val);
        System.out.println(node2.next.next.next.next.next.val);*/
    }
}
