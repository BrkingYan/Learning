package SwordToOffer.NK24.FindPath_____________;


import java.util.ArrayList;

/*
* 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
* 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
* (注意: 在返回值的list中，数组长度大的数组靠前)
* */
class Solution {
    ArrayList<ArrayList<Integer>> totalPath = new ArrayList<>();
    ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null && target == 0){
            return totalPath;
        }
        FindSubPath(root,target,new ArrayList<>());
        return totalPath;
    }

    //这个函数的功能就是往totalPath里面添加子路径
    private void FindSubPath(TreeNode root, int target,ArrayList<Integer> formerList) {
        ArrayList<Integer> currentPath = new ArrayList<>(formerList);
        if (root.val == target && root.left == null && root.right == null){ //到这一步说明是一条成功的路径，就添加进去
            currentPath.add(root.val);
            totalPath.add(currentPath);
        }else if (root.val < target){
            currentPath.add(root.val);
            if (root.left != null){
                FindSubPath(root.left,target-root.val,currentPath);
            }
            if (root.right != null){
                FindSubPath(root.right,target-root.val,currentPath);
            }
        }
    }
}
