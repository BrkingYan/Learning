package MI_OJ;

import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Solution {
    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr = new int[]{0,0,0};
        List<List<Integer>> total = threeSum(arr);
        System.out.println(total);

    }

    private synchronized void run(){

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-2){
            if (i >= 1 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            int first = nums[i];
            int secondIdx = i+1;
            int thirdIdx = nums.length-1;
            while(secondIdx < thirdIdx){
                if(nums[secondIdx] == nums[thirdIdx]){
                    temp.add(first);
                    temp.add(nums[secondIdx]);
                    temp.add(nums[thirdIdx]);
                    total.add(new ArrayList<>(temp));
                    temp.clear();
                    return total;
                }
                while(nums[secondIdx] == nums[secondIdx+1]) secondIdx++;
                while(nums[thirdIdx] == nums[thirdIdx-1]) thirdIdx--;
                int sum = first + nums[secondIdx] + nums[thirdIdx];
                if(sum == 0){
                    temp.add(first);
                    temp.add(nums[secondIdx]);
                    temp.add(nums[thirdIdx]);
                    total.add(new ArrayList<>(temp));
                    temp.clear();
                    secondIdx++;
                    thirdIdx--;
                }else if (sum > 0){
                    thirdIdx--;
                }else {
                    secondIdx++;
                }
            }
            i++;
        }

        return total;
    }
}
