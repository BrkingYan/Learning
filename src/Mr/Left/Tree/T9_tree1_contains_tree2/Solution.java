package Mr.Left.Tree.T9_tree1_contains_tree2;


import Mr.Left.Tree.TreeNode;

/*
*  判断 树2 是否是 树1的子结构
* */
public class Solution {
    public static void main(String[] args) {

    }

    private static boolean contains(TreeNode big,TreeNode small){
        //先利用isSameRoot寻找相同节点，如果当前结点不同，则按照中序遍历去搜寻相同节点
        //相同节点确定后，最后在isSanmeRoot里面排查
        return isSameTree(big,small) || contains(big.left,small) || contains(big.right,small);
    }

    private static boolean isSameTree(TreeNode parent,TreeNode child){
        if (child == null){
            return true;
        }
        //从节点相同的地方开始匹配
        if (parent == null || parent.val != child.val){
            return false;
        }
        return isSameTree(parent.left,child.left) && isSameTree(parent.right,child.right);
    }
}
