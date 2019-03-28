package SwordToOffer.NK25.Clone;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        RandomListNode node1 = new RandomListNode(2);
        node1.next = new RandomListNode(3);
        node1.next.next = new RandomListNode(4);
        node1.random = node1.next.next;
        node1.next.random = node1;
        node1.next.next.random = node1.next;

        RandomListNode testNode = solution.Clone(node1);
        System.out.println(testNode.next.next.label);
        System.out.println(testNode.random.label);
        System.out.println(testNode.next.random.label);


    }
}
