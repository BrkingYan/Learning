package SwordToOffer.NK15.ReverseList;

public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = solution.ReverseList(node);
    }
}
