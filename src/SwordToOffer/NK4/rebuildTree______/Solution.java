package SwordToOffer.NK4.rebuildTree______;


/*
*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
* */
public class Solution {

    TreeNode root;
    int[] preLeft;
    int[] preRight;
    int[] inLeft;
    int[] inRight;

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        return constructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode constructBinaryTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        root = new TreeNode(pre[preStart]);
        for (int i = 0;i < pre.length;i++){
            if (pre[preStart] == in[i]){
                inEnd = i;
            }
        }
        preStart++;
        //constructBinaryTree();
        return root;
    }
}
