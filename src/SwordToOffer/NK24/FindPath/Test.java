package SwordToOffer.NK24.FindPath;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(10);
        node1.left = new TreeNode(5);
        node1.right = new TreeNode(12);
        node1.left.right = new TreeNode(7);
        node1.right.left = new TreeNode(4);

        List<ArrayList<Integer>> lists = solution.FindPath(node1,22);
        System.out.println(lists);


        TreeNode node2 = null;
        List<ArrayList<Integer>> lists2 = solution.FindPath(node2,0);
        System.out.println(lists2);

    }
}
