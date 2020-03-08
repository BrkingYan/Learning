package Mr.Left.Tree.T9_tree1_contains_tree2;


import Mr.Left.Tree.TreeNode;

/*
*  �ж� ��2 �Ƿ��� ��1���ӽṹ
* */
public class Solution {
    public static void main(String[] args) {

    }

    private static boolean contains(TreeNode big,TreeNode small){
        //������isSameRootѰ����ͬ�ڵ㣬�����ǰ��㲻ͬ�������������ȥ��Ѱ��ͬ�ڵ�
        //��ͬ�ڵ�ȷ���������isSanmeRoot�����Ų�
        return isSameTree(big,small) || contains(big.left,small) || contains(big.right,small);
    }

    private static boolean isSameTree(TreeNode parent,TreeNode child){
        if (child == null){
            return true;
        }
        //�ӽڵ���ͬ�ĵط���ʼƥ��
        if (parent == null || parent.val != child.val){
            return false;
        }
        return isSameTree(parent.left,child.left) && isSameTree(parent.right,child.right);
    }
}
