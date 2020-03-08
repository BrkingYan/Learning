package SwordToOffer.NK26.Convert;

import java.util.LinkedList;

/*
* ����һ�ö��������������ö���������ת����һ�������˫������
* Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
* */
public class Solution3 {
    private LinkedList<TreeNode> queue = new LinkedList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        enQueue(pRootOfTree,queue);
        TreeNode head = queue.poll();
        TreeNode current = head;
        TreeNode temp;
        while (!queue.isEmpty()){
            temp = queue.poll();
            current.right = temp;
            temp.left = current;
            current = temp;
        }
        return head;
    }

    private static void enQueue(TreeNode root,LinkedList<TreeNode> queue){
        if (root == null){
            return;
        }
        if (root.left != null){
            enQueue(root.left,queue);
        }
        queue.add(root);
        if (root.right != null){
            enQueue(root.right,queue);
        }
    }
}
