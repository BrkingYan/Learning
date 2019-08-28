package SwordToOffer.NK4.rebuildTree______;

/*
*����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
* ���������ǰ���������������Ľ���ж������ظ������֡�
* ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
