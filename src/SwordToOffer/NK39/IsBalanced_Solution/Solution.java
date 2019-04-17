package SwordToOffer.NK39.IsBalanced_Solution;

/*
* ����һ�ö��������жϸö������Ƿ���ƽ���������
*
* ƽ�������:
* ����һ �ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1����������������������һ��ƽ�������
* */
class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        if (Math.abs(calTreeDepth(root.left)-calTreeDepth(root.right)) <= 1){
            return true;
        }
        return false;
    }

    private int calTreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int depth = 1;
        int leftDepth = calTreeDepth(root.left);
        int rightDepth = calTreeDepth(root.right);

        if (leftDepth > rightDepth){
            return leftDepth + depth;
        }
        return rightDepth + depth;

    }
}
