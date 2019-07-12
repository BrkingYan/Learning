package SwordToOffer.NK57.GetNext;


/*
* ����һ�������������е�һ����㣬
* ���ҳ��������˳�����һ����㲢�ҷ��ء�
* ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣��
*
*  �Ҹ��ڵ�
* */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }

        if (pNode.right == null){
            while (pNode.next != null){
                if (pNode.next.left == pNode){
                    return pNode.next;
                }
                pNode = pNode.next;
            }
            return null;
        }else {
            return getMostLeft(pNode.right);
        }
    }

    private TreeLinkNode getMostLeft(TreeLinkNode node){
        TreeLinkNode cur = node;
        while (cur.left != null){
            cur = cur.left;
        }
        /*if (cur.right != null){
            return cur.right;
        }*/
        return cur;
    }
}
