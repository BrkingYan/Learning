package SwordToOffer.NK57.GetNext;


/*
* 给定一个二叉树和其中的一个结点，
* 请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。、
*
*  找父节点
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
