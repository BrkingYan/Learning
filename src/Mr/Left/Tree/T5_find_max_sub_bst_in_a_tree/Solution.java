package Mr.Left.Tree.T5_find_max_sub_bst_in_a_tree;


import Mr.Left.Tree.TreeNode;

/*
*  找出一个二叉树中的最大的(节点最多)二叉搜索树
* */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(4);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(11);
        //root.right.right = new TreeNode(15);
        //System.out.println(isBST(root));
        //System.out.println(getNum(root.left.left));
        System.out.println(findMaxSubBST(root).val);
    }


    private static TreeNode findMaxSubBST(TreeNode root){
        if (isBST(root)){
            return root;
        }
        TreeNode left = findMaxSubBST(root.left);
        TreeNode right = findMaxSubBST(root.right);
        return getNum(left) > getNum(right) ? left : right;
    }

    private static boolean isBST(TreeNode root){
        if (root == null){
            return true;
        }
        boolean leftFlag;
        boolean rightFlag;
        if (root.left != null){
            leftFlag = root.val > root.left.val;
        }else {
            leftFlag = true;
        }
        if (root.right != null){
            rightFlag = root.val < root.right.val;
        }else {
            rightFlag = true;
        }
        if (leftFlag && rightFlag){
            return isBST(root.left) && isBST(root.right);
        }
        return false;
    }

    private static int getNum(TreeNode root){
        if (root == null){
            return 0;
        }
        return getNum(root.left) + getNum(root.right) + 1;
    }
}
