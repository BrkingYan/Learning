package Mr.Left.Tree.T12_isBST_or_complete_tree;


import Mr.Left.Tree.TreeNode;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/*
*  判断一棵树是否是BST或者完全二叉树
* */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(4);
        System.out.println(isBST(root));
        System.out.println(isComplete(root));
    }

    private static boolean isBST(TreeNode root){
        if (root == null){
            return true;
        }
        boolean left = false;
        if (root.left != null){
            if (root.left.val < root.val){
                left = true;
            }
        }else {
            left = true;
        }
        boolean right = false;
        if (root.right != null){
            if (root.right.val > root.val){
                right = true;
            }
        }else {
            right = true;
        }
        return left && right && isBST(root.left) && isBST(root.right);
    }

    //按层打印
    private static boolean isComplete(TreeNode root){
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        boolean leftMustBeLeaf = false;
        while (!queue.isEmpty()){
            temp = queue.poll();
            if (leftMustBeLeaf && !isLeaf(temp)){
                return false;
            }
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }else {
                leftMustBeLeaf = true;
            }
        }
        return true;
    }

    private static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
