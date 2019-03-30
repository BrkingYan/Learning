package SwordToOffer.NK26.Convert;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null){
            return null;
        }
        TreeNode head;
        TreeNode current;
        List<Integer> orderList = new ArrayList<>();
        getInCurrentNode(pRootOfTree,orderList);
        head = new TreeNode(orderList.get(0));
        current = head;
        for (int i = 1;i < orderList.size();i++){
            current.right = new TreeNode(orderList.get(i));
            current.right.left = current;
            current = current.right;
        }
        return head;
    }

    public void getInCurrentNode(TreeNode root, List<Integer> list){
        if (root != null){
            getInCurrentNode(root.left,list);
        }else {
            return;
        }
        list.add(root.val);
        getInCurrentNode(root.right,list);
    }
}
