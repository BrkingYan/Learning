package search;

import java.util.ArrayList;
import java.util.List;

/*
* ���������BST�ܹ���������������Ժ�����������ҵĸ�Ч�Խ������
*
* BST���ص㣺
*           ÿ���ڵ��ϵ�ֵ����һ���������Ҽ�������ֵ
*           ÿ���ڵ�ļ���������������������ڵ�ļ�������С����������������ڵ�ļ�
*           ������ǽ�BST�����м�ֵ����ͶӰ��һ��ֱ���ϣ���ô�ͻ�õ�һ����������С�
*           ( ͬһ���������п����ɶ����ͬ��BST��ʾ )
*
*      ���ܣ�
*           �㷨������ʱ��ȡ����������״��������״��ȡ���ڼ��Ĳ���˳��
*           ����������ĳɱ��ȶ��ֲ��Ҹߣ����ǲ���ɱ��ȶ��ֲ��ҵͺܶ�
*
*           ���������£����Ǻ����
* */
public class BinarySearchTree {
    private TreeNode root;

    private class TreeNode{
        private int key;
        private String value;
        private TreeNode left,right;
        private int N;//�ڵ����������¼���Ըýڵ�Ϊ���������Ľڵ�����
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

    //�÷��������Խڵ�rootΪ���������ܽڵ���������root����
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

    //�÷�����������key��value������rootΪ������������һ��һ�����Ľṹ�ı䣬����rootҲ�͸ı���
    private TreeNode put(TreeNode root,int key,String value){
        //����ҵ���һ���սڵ㣬˵��֮ǰ������û�д˼�����˴����½ڵ㲢���
        if (root == null){
            return new TreeNode(key,value,1);
        }
        int compare = compare(key,root.key);
        if (compare < 0){//key��root��keyС���͵ð���������������
            root.left =  put(root.left,key,value);
        }else if (compare > 0){
            root.right =  put(root.right,key,value);
        }else {//�ҵ��ˣ��޸�ԭֵ�����޸�����ֵ
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
    //��������Ϊk�Ľڵ�ļ�ֵ
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

    //�÷���ɾ����rootΪ��������ֵΪkey�Ľڵ㣬�����ظ��ڵ�
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
        return root;//δ����
    }

    public void delete(int key){
        delete(root,key);
    }

    private void deleteMin(){
        root = deleteMin(root);
    }

    //�÷���ɾ����root�ڵ�Ϊ����������Сֵ��������ɾ��Ԫ�غ����ĸ�
    private TreeNode deleteMin(TreeNode root){
        if (root.left == null){
            return root.right;
        }
        root.left = deleteMin(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    //���ر�����С�ļ�ֵ
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

    //�������ļ�
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
