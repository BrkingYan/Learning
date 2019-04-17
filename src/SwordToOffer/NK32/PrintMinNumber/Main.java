package SwordToOffer.NK32.PrintMinNumber;

import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,5,1,4,2};
        int[] numbers2 = new int[]{3,32,321};
        int[] numbers3 = new int[]{3334,3,3333332};
        Solution solution = new Solution();
        System.out.println(solution.PrintMinNumber(numbers3));
        System.out.println(solution.aShouldBeforeB("3","3334"));
    }
}
