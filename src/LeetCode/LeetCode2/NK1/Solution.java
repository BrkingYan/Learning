package LeetCode.LeetCode2.NK1;


import java.util.LinkedList;

/*
* 给定二叉树，找到它的最小深度。最小深度是从根节点到最近叶节点的最短路径上的节点数。
* */
public class Solution {
    //深度优先遍历 DFS
    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = run(root.left);
        int rightDepth = run(root.right);
        if (leftDepth == 0 || rightDepth == 0){
            return leftDepth + rightDepth + 1;
        }
        return Math.min(leftDepth,rightDepth) + 1;
    }

    //广度优先遍历，直接找层数
    public int BFS(TreeNode root){
        if (root == null){
            return 0;
        }
        TreeNode temp;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //最上面一层只有一个，因此end为1
        int depth = 1;
        int current = 0;
        int end = 1;
        while (!queue.isEmpty()){
            temp = queue.poll();
            current++;//自增，指向该层的下一位
            if (temp.left == null && temp.right == null){
                return depth;
            }
            //添加每个节点的子节点
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
            //这时已经搞完了一整层
            if (current == end){
                depth++;
                current = 0;
                end = queue.size();//这部很重要，规定了每一层的元素个数
            }
        }
        return depth;
    }
}
