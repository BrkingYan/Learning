package SwordToOffer.NK17.HasSubtree______;

import java.util.ArrayList;
import java.util.List;

/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */
class Solution2 {
    private List<Integer> preList1 = new ArrayList<>();
    private List<Integer> inList1 = new ArrayList<>();
    private List<Integer> preList2 = new ArrayList<>();
    private List<Integer> inList2 = new ArrayList<>();
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null && root2 == null){
            return false;
        }else {
            boolean flag1 = false;
            int count1 = 0;
            boolean flag2 = false;
            int count2 = 0;
            getPreCurrentNode(root1,preList1);
            getInCurrentNode(root1,inList1);
            getInCurrentNode(root2,preList2);
            getInCurrentNode(root2,inList2);
            for (int i = 0;i < preList2.size();i++){
                preList1.remove(0);
            }
            for (int i = 0;i < preList2.size();i++){
                if (preList1.get(i).equals(preList2.get(i))){
                    count1 ++;
                }
            }
            if (count1 == preList2.size()){
                flag1 = true;
            }

            for (int i = 0;i < inList2.size();i++){
                inList1.remove(0);
            }
            for (int i = 0;i < inList2.size();i++){
                if (inList1.get(i).equals(inList2.get(i))){
                    count2 ++;
                }
            }
            if (count2 == preList2.size()){
                flag2 = true;
            }

            return flag1 && flag2;
        }

    }

    public void getPreCurrentNode(TreeNode root, List<Integer> list){
        if (root != null){
            list.add(root.val);
        }else {
            return;
        }
        getPreCurrentNode(root.left,list);
        getPreCurrentNode(root.right,list);

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
