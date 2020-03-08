package sort.Review;

import java.util.ArrayList;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,2,4};
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        twoSum(arr,new ArrayList<>(),total,0,5);
        System.out.println(total);
    }

    private static void twoSum(int[] arr, ArrayList<Integer> list,ArrayList<ArrayList<Integer>> total,
                               int start,int target){
        if (target == 0){
            total.add(new ArrayList<>(list));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = start+1;i<arr.length;i++){
            list.add(arr[i]);
            twoSum(arr,list,total,i+1,target-arr[i]);
            list.remove(list.size()-1);
        }
    }
}
