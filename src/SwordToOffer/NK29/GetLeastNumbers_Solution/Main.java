package SwordToOffer.NK29.GetLeastNumbers_Solution;

import java.util.ArrayList;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> list = solution.GetLeastNumbers_Solution(input,k);
        System.out.print(list);
    }
}
