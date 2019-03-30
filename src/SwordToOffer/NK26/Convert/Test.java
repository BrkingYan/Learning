package SwordToOffer.NK26.Convert;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);*/

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(1);

        TreeNode linkRoot = solution.Convert(root);
        System.out.println(linkRoot.right.right.right.right.left.val);
    }
}
