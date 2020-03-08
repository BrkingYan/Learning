package sort.Review;

import java.util.*;

/*
*  数组中3个数之和为目标值
* */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,7,6,9,12,15};
        System.out.println(threeSum(arr,10));
        //System.out.println(twoSum(arr,13));
    }

    private static List<List<Integer>> twoSum(int[] arr,int target){
        List<List<Integer>> total = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        for(int i = 0;i < len;i++){
            if (arr[i] > target){
                break;
            }
            //去重
            if (i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            int right = len-1;
            while (i < right){
                int sum = arr[i] + arr[right];
                if (sum == target){
                    total.add(Arrays.asList(arr[i],arr[right]));
                    //去重
                    while (i < right && arr[right] == arr[right-1]) right--;
                    right--;
                }else {
                    right--;
                }
            }
        }
        return total;
    }

    private static List<List<Integer>> threeSum(int[] arr,int target){
        List<List<Integer>> total = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        for(int i = 0;i < len;i++){
            if (arr[i] > target){
                break;
            }
            //去重
            if (i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = len-1;
            while (left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target){
                    total.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    //去重
                    while (left < right && arr[left] == arr[left+1]) left++;
                    while (left < right && arr[right] == arr[right-1]) right--;
                left++;
                right--;
                }else if (sum < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return total;
    }
}
