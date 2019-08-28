package SwordToOffer.NK4.rebuildTree______;

/*
*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
* */
public class Solution2 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd) {
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode head = new TreeNode(pre[preStart]);
        int index = indexOf(in,pre[preStart]);
        int leftLength = index - inStart;
        //int rightLength = inEnd - index;
        head.left = reConstructBinaryTree(pre,preStart+1,preStart+leftLength,in,inStart,index-1);
        head.right = reConstructBinaryTree(pre,preStart+1+leftLength,preEnd,in,index+1,inEnd);
        return head;
    }

    private int indexOf(int[] arr,int num){
        int index;
        for (int i = 0;i<arr.length;i++){
            if (num == arr[i]){
                index = i;
                return index;
            }
        }
        return -1;
    }
}
