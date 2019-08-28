package Mr.Left.Tree.T4_max_path_of_a_sum;


import Mr.Left.Tree.TreeNode;

import java.util.*;

/*
* 找到累计和为sum的最长路径
* */
public class Solution {
    private static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        findPath(root,4);
        System.out.println(paths);
    }

    // map  key = sum   value 这个累加和在路径中最早出现的路径的层数
    private static void findPath(TreeNode root,int target){
        goDFS(root,new ArrayList<>(),0,target);
    }

    private static void goDFS(TreeNode root,ArrayList<Integer> formerPath,int formSum,int target){
        if (root == null){
            return;
        }
        ArrayList<Integer> currentPath = new ArrayList<>(formerPath);
        currentPath.add(root.val);
        int sum = formSum + root.val;
        if(sum == target){
            if (paths.size() == 0){
                paths.add(currentPath);
            }else if (currentPath.size() > paths.get(0).size()){
                paths.remove(0);
                paths.add(currentPath);
            }

        }else if(sum < target){
            if(root.left != null){
                goDFS(root.left,currentPath,sum,target);
            }
            if(root.right != null){
                goDFS(root.right,currentPath,sum,target);
            }
        }
    }

    private static int findMaxArrLen(int[] arr){
        return 1;
    }
}
