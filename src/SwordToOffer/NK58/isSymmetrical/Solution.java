package SwordToOffer.NK58.isSymmetrical;

/*
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 *
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }
        return hasSameTree(pRoot.left,pRoot.right);
    }

    private boolean hasSameTree(TreeNode left,TreeNode right){
        if (left == null){
            return right == null;
        }
        if (right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }

        return hasSameTree(left.left,right.right) && hasSameTree(left.right,right.left);
    }
}
