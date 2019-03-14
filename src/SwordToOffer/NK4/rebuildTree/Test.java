package SwordToOffer.NK4.rebuildTree;

public class Test {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arrayPre = new int[]{1,2,4,7,3,5,6,8};
        int[] arrayIn = new int[]{4,7,2,1,5,3,8,6};
        solution.reConstructBinaryTree(arrayPre,arrayIn);
    }
}
