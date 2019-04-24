package SwordToOffer.NK45.isContinuous;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        Solution solution = new Solution();
        /*solution.sort(a,0,7);
        for (int e : a){
            System.out.println(e);
        }*/
        int[] numbers = new int[]{0,3,1,6,4};
        System.out.println(solution.isContinuous(numbers));
    }
}
