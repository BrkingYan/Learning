package search;

import java.util.ArrayList;
import java.util.List;

/*
* 二叉查找树BST能够将链表插入的灵活性和有序数组查找的高效性结合起来
*
* BST的特点：
*           每个节点上的值都是一个键，并且键关联了值
*           每个节点的键都大于其左子树中任意节点的键，并且小于其右子树的任意节点的键
*           如果我们将BST的所有键值向下投影到一条直线上，那么就会得到一个有序的序列。
*           ( 同一个有序序列可以由多个不同的BST表示 )
*
*      性能：
*           算法的运行时间取决于树的形状，树的形状又取决于键的插入顺序
*           查找随机键的成本比二分查找高，但是插入成本比二分查找低很多
*
*           在最坏的情况下，还是很糟糕
* */
public class BinarySearchTree {
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
        if (root == null){
            return null;
        }
        if (key < root.key){
            return get(root.left,key);
        }else if (key > root.key){
            return get(root.right,key);
        }else {
            return root.value;
        }
    }

    public void put(int key,String value){
        root = put(root,key,value);
    }

    //该方法可以利用key和value更新以root为根的整个树，一旦一个树的结构改变，它的root也就改变了
    private TreeNode put(TreeNode root,int key,String value){
        //如果找到了一个空节点，说明之前的树中没有此键，因此创建新节点并添加
        if (root == null){
            return new TreeNode(key,value,1);
        }
        int compare = compare(key,root.key);
        if (compare < 0){//key比root的key小，就得把它放在左子树中
            root.left =  put(root.left,key,value);
        }else if (compare > 0){
            root.right =  put(root.right,key,value);
        }else {//找到了，修改原值，并修改容量值
            root.value = value;
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;
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
        if (root == null){
            return 0;
        }
        int comp = compare(key,root.key);
        if (comp < 0){
            return rank(key,root.left);
        }else if (comp > 0){
            return rank(key,root.right) + 1 + size(root.left);
        }else {
            return size(root.left);
        }
    }
    //返回排名为k的节点的键值
    public int select(int k){
        return select(root,k).key;
    }

    private TreeNode select(TreeNode root,int k){
        if (root == null){
            return null;
        }
        int leftNum = size(root.left);
        int comp = compare(k,leftNum);
        if (comp == 0){
            return root;
        }else if (comp < 0){
            return select(root.left,k);
        }else {
            return select(root.right,k-leftNum-1);
        }
    }

    //该方法删除以root为根的树的值为key的节点，并返回根节点
    private TreeNode delete(TreeNode root,int key){
        if (root == null){
            return null;
        }
        int comp = compare(key,root.key);
        if (comp == 0){
             if (root.left == null){
                 return root.right;
             }
             if (root.right == null){
                 return root.left;
             }
             TreeNode rightMin = min(root.right);
             rightMin.left = root.left;
             rightMin.right = deleteMin(root.right);
             rightMin.N = size(rightMin.left) + size(rightMin.right) +  1;
             return rightMin;
        }else if (comp < 0){
            root.left = delete(root.left,key);
        }else {
            root.right = delete(root.right,key);
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;//未命中
    }

    public void delete(int key){
        delete(root,key);
    }

    private void deleteMin(){
        root = deleteMin(root);
    }

    //该方法删除以root节点为根的树的最小值，并返回删除元素后树的根
    private TreeNode deleteMin(TreeNode root){
        if (root.left == null){
            return root.right;
        }
        root.left = deleteMin(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    //返回表中最小的键值
    public int min(){
        return min(root).key;
    }

    private TreeNode min(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.left != null){
            return min(root.left);
        }else {
            return root;
        }
    }

    //返回最大的键
    public int max(){
        return max(root).key;
    }

    private TreeNode max(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.right == null){
            return root;
        }
        return max(root.right);
    }
}
