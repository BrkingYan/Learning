package SwordToOffer.NK25.Clone;


/*
 *  ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 *  ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
