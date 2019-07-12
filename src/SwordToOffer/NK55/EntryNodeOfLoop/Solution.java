package SwordToOffer.NK55.EntryNodeOfLoop;


import java.util.HashSet;

/*
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
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
