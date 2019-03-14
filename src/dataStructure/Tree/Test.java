package dataStructure.Tree;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Test test = new Test();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(6);

        List<Integer> list = new ArrayList<>();
        //test.getPreCurrentNode(root,list);
        //System.out.println(list);
        //test.getInCurrentNode(root,list);
        //System.out.println(list);
        test.getPostCurrentNode(root,list);
        System.out.println(list);
    }

    //先序遍历
    public void getPreCurrentNode(TreeNode root, List<Integer> list){
        if (root != null){
            list.add(root.val);
        }else {
            return;
        }
        getPreCurrentNode(root.left,list);
        getPreCurrentNode(root.right,list);

    }
    //中序遍历
    public void getInCurrentNode(TreeNode root, List<Integer> list){
        if (root != null){
            getInCurrentNode(root.left,list);
        }else {
            return;
        }
        list.add(root.val);
        getInCurrentNode(root.right,list);
    }
    //后序遍历
    public void getPostCurrentNode(TreeNode root,List<Integer> list){
        if (root != null){
            getPostCurrentNode(root.left,list);
        }else {
            return;
        }
        getPostCurrentNode(root.right,list);
        list.add(root.val);
    }
}
