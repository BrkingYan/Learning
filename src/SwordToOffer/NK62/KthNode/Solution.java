package SwordToOffer.NK62.KthNode;

import java.util.*;

/*
 * ����һ�ö��������������ҳ����е�  ��kС�Ľ�㡣
 * ���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 *
 * Ҫô��һ�ÿ���
 * �����Ϊ�գ���ô���������ڵ��ֵ��С�ڸ��ڵ��ֵ���������ڵ��ֵ�����ڸ��ڵ��ֵ
 * ����������Ҳ�Ƕ���������
 * */
public class Solution {
    private List<TreeNode> list;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null){
            return null;
        }

        list = new ArrayList<>();
        inOrder(pRoot,list);
        if (k > list.size() || k < 1){
            return null;
        }
        return list.get(k-1);
    }

    private void inOrder(TreeNode root,List<TreeNode> list){
        if (root.left != null){
            inOrder(root.left,list);
        }
        list.add(root);
        if (root.right != null){
            inOrder(root.right,list);
        }

    }
}
