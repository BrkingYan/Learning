package SwordToOffer.NK58.isSymmetrical;

/*
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 *
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }
        return hasSameTree(pRoot.left,pRoot.right);
    }

    private boolean hasSameTree(TreeNode left,TreeNode right){
        if (left == null){
            return right == null;
        }
        if (right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }

        return hasSameTree(left.left,right.right) && hasSameTree(left.right,right.left);
    }
}
