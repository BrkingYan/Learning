package SwordToOffer.NK17.HasSubtree______;


/*
* �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
* ��ps������Լ��������������һ�������ӽṹ��
* */
public class Solution3 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return isSameTree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    private boolean isSameTree(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
        }else {
            return false;
        }
    }
}
