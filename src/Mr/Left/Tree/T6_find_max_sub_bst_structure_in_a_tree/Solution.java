package Mr.Left.Tree.T6_find_max_sub_bst_structure_in_a_tree;


import Mr.Left.Tree.TreeNode;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
*  找到一棵树的最大BST子结构
* */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(1);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(13);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(14);
        root.right.left.left.left = new TreeNode(2);
        root.right.left.left.right = new TreeNode(5);
        root.right.left.right.left = new TreeNode(11);
        root.right.left.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(20);
        root.right.right.right = new TreeNode(16);

        findMaxBST2(root);
    }

    //private static LinkedList<TreeNode> queue = new LinkedList<>();
    private static TreeNode findMaxBST2(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode cur;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur.left != null && cur.left.val < cur.val){
                queue.add(cur.left);
            }else {
                cur.left = null;
            }
            if (cur.right != null && cur.right.val > cur.val){
                queue.add(cur.right);
            }else {
                cur.right = null;
            }
        }
        return root;
    }
}
