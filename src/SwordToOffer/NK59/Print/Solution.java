package SwordToOffer.NK59.Print;

import java.util.*;

/*
* 请实现一个函数按照之字形打印二叉树，
* 即
* 第一行按照从左到右的顺序打印，
* 第二层按照从右至左的顺序打印，
* 第三行按照从左到右的顺序打印，其他行以此类推。
* */
public class Solution {
    LinkedList<TreeNode> stack1 = new LinkedList<>();
    LinkedList<TreeNode> stack2 = new LinkedList<>();

    Map<Integer,LinkedList<TreeNode>> map = new HashMap<>();

    LinkedList<TreeNode> fullStack;
    LinkedList<TreeNode> emptyStack;

    ArrayList<Integer> aResult;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (pRoot == null){
            return new ArrayList<>();
        }

        int isNegtive = 0;
        map.put(0,stack1);
        map.put(1,stack2);

        stack1.push(pRoot);
        fullStack = stack1;
        emptyStack = stack2;

        isNegtive = 1;

        TreeNode temp;
        LinkedList<TreeNode> tempStack;

        while (!(fullStack.isEmpty() && emptyStack.isEmpty())){
           aResult = new ArrayList<>();
           fullStack = map.get((isNegtive +1)%2);
           emptyStack = map.get(isNegtive);
           while (!fullStack.isEmpty()){
               temp = fullStack.pop();
               aResult.add(temp.val);
               if (isNegtive == 1){
                   if (temp.left != null)
                       emptyStack.push(temp.left);
                   if (temp.right != null)
                       emptyStack.push(temp.right);
               }else {
                   if (temp.right != null)
                       emptyStack.push(temp.right);
                   if (temp.left != null)
                       emptyStack.push(temp.left);
               }
           }
           list.add(new ArrayList<>(aResult));
           isNegtive = (isNegtive +1) % 2;
       }
       return list;
    }

}
