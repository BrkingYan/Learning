package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree_unRecursive {
    private TreeNode root;

    private class TreeNode{
        private int key;
        private String value;
        private TreeNode left,right;
        private int N;//节点计数器，记录了以该节点为根的子树的节点总数
        TreeNode(int key,String val,int N){
            this.key = key;
            this.value = val;
            this.N = N;
        }

        @Override
        public String toString() {
            return "[" + key + "-" + value + "]";
        }
    }

    public int size(){
        return size(root);
    }

    //该方法返回以节点root为根的树的总节点数，包括root自身
    public int size(TreeNode root){
        if (root == null){
            return 0;
        }
        return root.N;
    }

    public String get(int key){
        return get(root,key);
    }

    private String get(TreeNode root,int key){
        TreeNode current = root;
        while (current != null){
            if (key == current.key){
                return current.value;
            }else if (key < current.key){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return null;
    }

    public void put(int key,String value){
        TreeNode current = root;
        if (root == null){
            root = new TreeNode(key,value,1);
            return;
        }
        while (current != null){
            if (key == current.key){
                current.value = value;
                return;
            }else if (key < current.key){
                if (current.left == null){
                    current.left = new TreeNode(key,value,1);
                    current.N++;
                    //root.N++;
                    return;
                }else {
                    current = current.left;
                }
            }else {
                if (current.right == null){
                    current.right = new TreeNode(key,value,1);
                    current.N++;
                    //root.N++;
                    return;
                }else {
                    current = current.right;
                }
            }
        }
        //root.N++;
    }



    private static int compare(int a,int b){
        if (a == b){
            return 0;
        }else if (a > b){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        List<TreeNode> list = new ArrayList<>();
        getTree(root,list);
        return list.toString();
    }

    private void getTree(TreeNode root,List<TreeNode> list){
        if (root == null){
            return;
        }
        if (root.left != null){
            getTree(root.left,list);
        }
        list.add(root);
        if (root.right != null){
            getTree(root.right,list);
        }
    }

    public int rank(int key){
        return rank(key,root);
    }

    private int rank(int key,TreeNode root){
        if (key == root.key){
            return size(root.left);
        }
        TreeNode current = root;
        int rank = 0;
        while (current != null){
            if (key == current.key){
                return rank;
            }else if (key < current.key){
                current = current.left;
            }else {
                rank = rank + 1 + size(current.left);
                current = current.right;
            }
        }
        return rank;
    }
}
