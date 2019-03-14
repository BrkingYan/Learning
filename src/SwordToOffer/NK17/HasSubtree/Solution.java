package SwordToOffer.NK17.HasSubtree;

import java.util.ArrayList;
import java.util.List;

/*
* 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
* */
class Solution {
    private TreeNode root2CurrentNode;
    private TreeNode root1CurrentNode;
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        root2CurrentNode = root2;
        return false;
    }


}

