package SwordToOffer.NK62.KthNode;

import java.util.*;

/*
 * 给定一棵二叉搜索树，请找出其中的  第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * 要么是一棵空树
 * 如果不为空，那么其左子树节点的值都小于根节点的值；右子树节点的值都大于根节点的值
 * 其左右子树也是二叉搜索树
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
