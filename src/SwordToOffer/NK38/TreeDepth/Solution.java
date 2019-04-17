package SwordToOffer.NK38.TreeDepth;

/*
*  输入一棵二叉树，求该树的深度。
*  从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
* */
class Solution {
    int TreeDepth(TreeNode root) {
        return calTreeDepth(root);
    }

    private int calTreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int depth = 1;
        int leftDepth = calTreeDepth(root.left);
        int rightDepth = calTreeDepth(root.right);

        if (leftDepth > rightDepth){
            return leftDepth + depth;
        }
        return rightDepth + depth;

    }
}
