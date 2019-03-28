package SwordToOffer.NK25.Clone;


/*
*  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
*  返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
* */
 class Solution {
     RandomListNode newHead;
     RandomListNode Clone(RandomListNode pHead) {
         if (pHead == null){
             return null;
         }
        RandomListNode currentHead = new RandomListNode(pHead.label);
        newHead = currentHead;
        while (pHead.next != null){
            currentHead.next = new RandomListNode(pHead.next.label);
            if (pHead.random != null){
                currentHead.random = new RandomListNode(pHead.random.label);
            }
            currentHead = currentHead.next;
            pHead = pHead.next;
        }
        return newHead;
    }
}
