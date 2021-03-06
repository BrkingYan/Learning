package SwordToOffer.NK26.Convert;


import java.util.LinkedList;
import java.util.Queue;

/*
*  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
*  要求不能创建任何新的结点，只能调整树中结点指针的指向。
*  {10,6,14,4,8,12,16}
* */
class Solution2 {

    TreeNode head = null;
    TreeNode currentHead = null;
    TreeNode currentLeft = null;
    Queue<TreeNode> orderQueue = new LinkedList<>();

    /*
    *  该法时间复杂度过高
    * */
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        createOrderQueue(pRootOfTree);
        head = orderQueue.peek();
        currentHead = head;
        while (!orderQueue.isEmpty()){
            orderQueue.poll();
            currentHead.right = orderQueue.peek();
            currentHead.left = currentLeft;
            currentLeft = currentHead;
            currentHead = currentHead.right;
        }
        return head;
    }

    private void createOrderQueue(TreeNode rootOfTree){
        if (rootOfTree.left == null){
            orderQueue.add(rootOfTree);
        }else {
            createOrderQueue(rootOfTree.left);
        }
        if (rootOfTree.right != null){
            createOrderQueue(rootOfTree.right);
        }
        orderQueue.add(rootOfTree);
    }
}
