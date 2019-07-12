package LeetCode.LeetCode2.NK1;


import java.util.LinkedList;

/*
* �������������ҵ�������С��ȡ���С����ǴӸ��ڵ㵽���Ҷ�ڵ�����·���ϵĽڵ�����
* */
public class Solution {
    //������ȱ��� DFS
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

    //������ȱ�����ֱ���Ҳ���
    public int BFS(TreeNode root){
        if (root == null){
            return 0;
        }
        TreeNode temp;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //������һ��ֻ��һ�������endΪ1
        int depth = 1;
        int current = 0;
        int end = 1;
        while (!queue.isEmpty()){
            temp = queue.poll();
            current++;//������ָ��ò����һλ
            if (temp.left == null && temp.right == null){
                return depth;
            }
            //���ÿ���ڵ���ӽڵ�
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
            //��ʱ�Ѿ�������һ����
            if (current == end){
                depth++;
                current = 0;
                end = queue.size();//�ⲿ����Ҫ���涨��ÿһ���Ԫ�ظ���
            }
        }
        return depth;
    }
}
