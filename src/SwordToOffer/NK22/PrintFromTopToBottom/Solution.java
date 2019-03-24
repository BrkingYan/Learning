package SwordToOffer.NK22.PrintFromTopToBottom;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
* */
class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
            list.add(root.val);
        }
        while (!queue.isEmpty()){
            if (root.left != null){
                queue.add(root.left);
                list.add(root.left.val);
            }
            if (root.right != null){
                queue.add(root.right);
                list.add(root.right.val);
            }
            queue.poll();
            root = queue.peek();
        }
        return list;
    }
}
