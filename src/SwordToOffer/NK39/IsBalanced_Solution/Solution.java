package SwordToOffer.NK39.IsBalanced_Solution;

/*
* 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*
* 平衡二叉树:
* 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
* */
class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        if (Math.abs(calTreeDepth(root.left)-calTreeDepth(root.right)) <= 1){
            return true;
        }
        return false;
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
