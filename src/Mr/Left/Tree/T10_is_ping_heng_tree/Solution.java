package Mr.Left.Tree.T10_is_ping_heng_tree;

import Mr.Left.Main;
import Mr.Left.Tree.TreeNode;

/*
*  判断一个二叉树是否是平衡二叉树
* */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(19);
        //root.right.left.left.right = new TreeNode(12);

        System.out.println(getHeight(root));
        System.out.println(isBalance(root));
    }

    private static boolean isBalance(TreeNode root){
        if (root == null){
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    private static int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight > rightHeight){
            return 1 + leftHeight;
        }else {
            return 1 + rightHeight;
        }
    }
}
