package SwordToOffer.NK26.Convert;

import java.util.LinkedList;

/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
* 要求不能创建任何新的结点，只能调整树中结点指针的指向。
* */
public class Solution3 {
    private LinkedList<TreeNode> queue = new LinkedList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        enQueue(pRootOfTree,queue);
        TreeNode head = queue.poll();
        TreeNode current = head;
        TreeNode temp;
        while (!queue.isEmpty()){
            temp = queue.poll();
            current.right = temp;
            temp.left = current;
            current = temp;
        }
        return head;
    }

    private static void enQueue(TreeNode root,LinkedList<TreeNode> queue){
        if (root == null){
            return;
        }
        if (root.left != null){
            enQueue(root.left,queue);
        }
        queue.add(root);
        if (root.right != null){
            enQueue(root.right,queue);
        }
    }
}
