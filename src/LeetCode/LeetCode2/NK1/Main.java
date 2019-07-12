package LeetCode.LeetCode2.NK1;

import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        Solution s = new Solution();
        System.out.println(s.BFS(root));
    }
}
