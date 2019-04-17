package SwordToOffer.NK40.FindNumsAppearOnce;


public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1,1,3,6};
        Solution solution = new Solution();
        int[] n1 = new int[1];
        int[] n2 = new int[1];
        solution.FindNumsAppearOnce(array,n1,n2);
        System.out.println(n1[0]);
        System.out.println(n2[0]);
    }
}
