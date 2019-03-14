package SwordToOffer.NK18.Mirror;


/*
*  求一个二叉树的镜像树
* */
class Solution {
    public void Mirror(TreeNode root) {
        TreeNode tempNode;
        if (root != null){
            tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
        }else {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
    }
}
