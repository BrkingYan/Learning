package Mr.Left.Tree.T1_bianli;

import Mr.Left.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class T1_bian_li {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        //pre_re(root);
        //pre(root);
        //in_re(root);
        //in(root);
        //post_re(root);
        post(root);
    }

    private static void pre_re(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        pre_re(root.left);
        pre_re(root.right);
    }

    private static void pre(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null){
            stack.push(root);
        }
        TreeNode cur;
        while (!stack.isEmpty()){
            cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    private static void in_re(TreeNode root){
        if (root == null){
            return;
        }
        in_re(root.left);
        System.out.println(root.val);
        in_re(root.right);
    }
    private static void in(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }


    private static void post_re(TreeNode root){
        if (root == null){
            return;
        }


        post_re(root.left);
        post_re(root.right);
        System.out.println(root.val);
    }

    private static void post(TreeNode root){
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        if (root != null){
            stack1.push(root);
            TreeNode cur;
            while (!stack1.isEmpty()){
                cur = stack1.pop();
                stack2.push(cur.val);
                if (cur.left != null){
                    stack1.addFirst(cur.left);
                    System.out.println(stack2);
                }
                if(cur.right != null){
                    stack1.addFirst(cur.right);
                }
            }
            System.out.println(stack2);
        }

    }
}
