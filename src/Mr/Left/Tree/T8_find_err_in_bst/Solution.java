package Mr.Left.Tree.T8_find_err_in_bst;


import Mr.Left.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*
* 1��һ�������������е������ڵ������λ�ã����ҳ��������ڵ�
*
* 2����1�Ļ����ϣ�����������ڵ��λ�û�����
* */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        TreeNode[] arr = findErr(root);
        System.out.println(arr[0].val);
        System.out.println(arr[1].val);
    }

    private static TreeNode[] findErr(TreeNode root){
        TreeNode[] err = new TreeNode[2];
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        int decCount = 0;
        if (root == null){
            return null;
        }
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                list.add(cur);
                if (list.size() > 1){
                    if (decCount == 0 && list.get(list.size()-1).val < list.get(list.size()-2).val){
                        err[0] = list.get(list.size()-2);
                        decCount++;
                    }
                    if (decCount == 1 && list.get(list.size()-1).val < list.get(list.size()-2).val){
                        err[1] = list.get(list.size()-1);
                    }
                }
                cur = cur.right;
            }
        }
        return err;
    }

    private static TreeNode exgErr(TreeNode root){
        return null;
    }
}
