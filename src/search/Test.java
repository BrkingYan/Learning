package search;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(5,"Ahaha");
        bst.put(2,"Bha");
        bst.put(3,"Chaha");
        bst.put(4,"Mhaha");
        bst.put(6,"Ghaha");
        //bst.put(6,"Ehaha");
        System.out.println(bst);
        bst.delete(3);
        System.out.println(bst);
        System.out.println(bst.min());


        /*BinarySearchTree_unRecursive bst2 = new BinarySearchTree_unRecursive();
        bst2.put(5,"Ahaha");
        bst2.put(2,"Bha");
        bst2.put(3,"Chaha");
        bst2.put(4,"Mhaha");
        bst2.put(6,"Ghaha");
        System.out.println(bst2);*/
    }
}
