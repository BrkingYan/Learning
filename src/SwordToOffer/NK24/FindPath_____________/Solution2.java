package SwordToOffer.NK24.FindPath_____________;

import java.util.ArrayList;

public class Solution2 {
    private ArrayList<ArrayList<Integer>> totalList;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        totalList = new ArrayList<>();
        if(root == null){
            return totalList;
        }

        goDFS(root,target,new ArrayList<>());
        return totalList;
    }

    private void goDFS(TreeNode root,int target,ArrayList<Integer> formerList){
        ArrayList<Integer> currentPath = new ArrayList<>(formerList);
        currentPath.add(root.val);
        int sum = sumList(currentPath);

        if(sum == target && root.left == null && root.right == null){
            totalList.add(currentPath);
        }else if(sum < target){
            if(root.left != null){
                goDFS(root.left,target,currentPath);
            }
            if(root.right != null){
                goDFS(root.right,target,currentPath);
            }
        }
    }

    private int sumList(ArrayList<Integer> list){
        int sum = 0;
        for(int e : list){
            sum += e;
        }
        return sum;
    }
}
