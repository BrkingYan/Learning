package Mr.Left.Tree.T4_max_path_of_a_sum;


import java.rmi.server.RMISocketFactory;
import java.util.ArrayList;
import java.util.LinkedList;

public class Max_Path {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val = val;
        }


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        System.out.print(findPath(root));


    }

    private static ArrayList<Integer> findPath(TreeNode root){
        helper(root,new ArrayList<>());
        return maxList;
    }

    private static ArrayList<Integer> maxList = new ArrayList<>();

    private static void helper(TreeNode root,ArrayList<Integer> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(root.val);
            if (list.size() > maxList.size()) {
                maxList = new ArrayList<>(list);
            }
        }else if (root.left != null && root.right == null){
            list.add(root.val);
            helper(root.left,list);
        }else if (root.left == null){
            list.add(root.val);
            helper(root.right,list);
        }else {
            list.add(root.val);
            helper(root.left,list);
            list.remove(list.size()-1);
            helper(root.right,list);
        }
    }
}
