package SwordToOffer.NK38.TreeDepth;

/*
*  ����һ�ö����������������ȡ�
*  �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
* */
class Solution {
    int TreeDepth(TreeNode root) {
        return calTreeDepth(root);
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
