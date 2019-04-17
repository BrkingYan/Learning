package SwordToOffer.NK35.InversePairs;

public class Main {
    public static void main(String[] args) {
        //int[] arr = new int[]{4,3,6,1,2,5};
        int[] arr = new int[]{1,2,3,4,5,6,0};
        Solution solution = new Solution();
        System.out.println(solution.InversePairs(arr));
        for (int i : arr){
            System.out.println(i);
        }
    }
}
