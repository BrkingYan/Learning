package dataStructure.BinarySearchTree;

import ThinkingInJava.ComparableInterface.StudentComparator;

import java.util.Comparator;

class BinarySearchTree <Person extends Comparable<? super Person>>{
    private BinaryNode<Person> root;
    private Comparator cmp;

    /*
     * 构造器
     * */
    public BinarySearchTree(){
        this(null);//相当于调用另外一个构造函数
    }

    public BinarySearchTree(Comparator<? super Person> cmp){
        root = null;
        this.cmp = cmp;
        StudentComparator p1 = new StudentComparator();

    }


    /*
    *  实现Person内部类
    * */
    private static class BinaryNode<Person>  {
        private BinaryNode left;
        private BinaryNode right;
        private Person person; //the data in the node

        BinaryNode(Person p){
            this.person = p;
        }

        BinaryNode(Person p, BinaryNode<Person> left, BinaryNode<Person> right){
            this.left = left;
            this.right = right;
        }

        public Person getPerson() {
            return person;
        }

        public BinaryNode<Person> getLeft() {
            return left;
        }

        public BinaryNode<Person> getRight() {
            return right;
        }
    }


    /*
    *  实现contains()方法
    * */
    public int myCompare(Person left,Person right){
        if (cmp != null){
            return cmp.compare(left,right);
        }else {
            return ((Comparable)left).compareTo(right);
        }
    }

    public boolean contains(Person p){
        return contains(p,root);
    }

    public boolean contains(Person p, BinaryNode<Person> root){
        if (root == null){
            return false;
        }
        int compareResult = myCompare(p,root.getPerson());
        if (compareResult == 0){
            return true;
        }else if (compareResult == -1){
            return contains(p,root.getLeft());
        }else {
            return contains(p,root.getRight());
        }
    }

    //实现isEmpty方法
    public boolean isEmpty(){
        return root == null;
    }

    //实现makeEmpty方法
    public void makeEmpty(){
        root = null;
    }

    //递归实现findMin方法
    public BinaryNode<Person> findMin(BinaryNode<Person> root){
        if (root == null){
            return null;
        }else if (root.left == null){
            return root;
        }
        return findMin(root.left);
    }

    //非递归实现findMax方法
    public BinaryNode<Person> findMax(BinaryNode<Person> root){
        if (root != null){
            while (root.right != null){
                root = root.right;
            }
        }
        return root;
    }

    //实现insert方法
    /*
    * 将一个元素插入到一个节点为root的子树中
    * */
    private BinaryNode<Person> insert(Person p,BinaryNode<Person> root){
        if (root == null){
            return new BinaryNode<Person>(p,null,null);
        }
        int compareResult = p.compareTo(root.person);
        if (compareResult < 0){
            return insert(p,root.left);
        }else if (compareResult > 0){
            return insert(p,root.right);
        }
        return root;
    }

    public void insert(Person p){
        root = insert(p,root);
    }

    //实现remove 方法
    /*
    *  移除查找树中的某个节点
    * */
    private BinaryNode<Person> remove(Person p,BinaryNode<Person> subTreeRoot){
        if (subTreeRoot == null){
            return subTreeRoot;
        }
        int compareResult = p.compareTo(subTreeRoot.person);
        //如果该值比节点处的值大，则去该节点的右子树中查找
        if (compareResult > 0){
            return remove(p,subTreeRoot.right);
        }else if (compareResult < 0){//如果该值比节点处的值小，则去该节点的左子树中查找
            return remove(p,subTreeRoot.left);
        }else if (subTreeRoot.left != null && subTreeRoot.right != null){ //若该值和节点处的值相等，则可确定移除位置，若该节点之前有两个子节点，则去右子树中找出最小值放在该节点处
            subTreeRoot.person = (Person) findMin(subTreeRoot.right).person;
            subTreeRoot.right = remove(p,subTreeRoot.right);
        }else {//若该节点原先只有一个子节点
            root = (root.left != null)?root.left:root.right;
        }
        return root;
    }

    public void remove(Person p){
        root = remove(p,root);
    }
    //实现printTree()方法


}
