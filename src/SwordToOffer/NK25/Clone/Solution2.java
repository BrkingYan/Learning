package SwordToOffer.NK25.Clone;


/*
 *  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *  返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * */
public class Solution2 {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode currentP = pHead;
        RandomListNode current = head;
        while (currentP.next != null){
            current.next = new RandomListNode(currentP.next.label);
            if (currentP.random != null){
                current.random = new RandomListNode(currentP.random.label);
            }
            current = current.next;
            currentP = currentP.next;
        }
        return head;
    }
}
