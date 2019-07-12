package SwordToOffer.NK60.PrintATree;

import SwordToOffer.NK57.GetNext.TreeLinkNode;

import java.util.*;

/*
* 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
* */
public class Solution {

    LinkedList<TreeNode> queue1 = new LinkedList<>();
    LinkedList<TreeNode> queue2 = new LinkedList<>();

    Map<Integer,LinkedList<TreeNode>> map = new HashMap<>();

    LinkedList<TreeNode> fullQueue;
    LinkedList<TreeNode> emptyQueue;

    ArrayList<Integer> aResult;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null){
            return new ArrayList<>();
        }

        int isNegtive = 0;
        map.put(0,queue1);
        map.put(1,queue2);

        queue1.add(pRoot);
        fullQueue = queue1;
        emptyQueue = queue2;

        isNegtive = 1;

        TreeNode temp;
        LinkedList<TreeNode> tempStack;

        while (!(fullQueue.isEmpty() && emptyQueue.isEmpty())){
            aResult = new ArrayList<>();
            fullQueue = map.get((isNegtive +1)%2);
            emptyQueue = map.get(isNegtive);
            while (!fullQueue.isEmpty()){
                temp = fullQueue.poll();
                aResult.add(temp.val);

                if (temp.left != null)
                    emptyQueue.add(temp.left);
                if (temp.right != null)
                    emptyQueue.add(temp.right);

            }
            list.add(new ArrayList<>(aResult));
            isNegtive = (isNegtive +1) % 2;
        }
        return list;
    }
}
