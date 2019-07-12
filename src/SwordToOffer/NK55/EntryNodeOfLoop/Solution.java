package SwordToOffer.NK55.EntryNodeOfLoop;


import java.util.HashSet;

/*
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * */
public class Solution {
    private HashSet<ListNode> set = new HashSet<>();
    private ListNode currentNode;
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        currentNode = pHead;
        while (currentNode != null){
            if (set.contains(currentNode.next)){
                return currentNode.next;
            }
            set.add(currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }
}
