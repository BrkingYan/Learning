package SwordToOffer.NK61.SerializeTree;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution s = new Solution();
        String str = s.Serialize(root);
        System.out.println(str);
    }
}
