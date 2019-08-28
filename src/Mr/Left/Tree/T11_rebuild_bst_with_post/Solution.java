package Mr.Left.Tree.T11_rebuild_bst_with_post;


import Mr.Left.Tree.TreeNode;

/*
*  根据后序遍历序列重建BST
* */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,5,7,6,4};
        TreeNode root = rebuildBST(arr,0,arr.length-1);
    }

    private static TreeNode rebuildBST(int[] arr,int start,int end){
        if (start > end){
            return null;
        }
        TreeNode head = new TreeNode(arr[end]);
        int mid = -1;
        for (int i = start;i<end;i++){
            if (arr[end] > arr[i]){
                mid = i;
            }else {
                break;
            }
        }
        head.left = rebuildBST(arr,start,mid);
        head.right = rebuildBST(arr,mid+1,end-1);
        return head;
    }
}
