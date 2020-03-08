package sort.Review;

import java.util.*;
class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,7,6,9,12,15};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // ����
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 10) break; // �����ǰ���ִ���0��������֮��һ������0�����Խ���ѭ��
            if(i > 0 && nums[i] == nums[i-1]) continue; // ȥ��
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 10){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // ȥ��
                    while (L<R && nums[R] == nums[R-1]) R--; // ȥ��
                    L++;
                    R--;
                }
                else if (sum < 10) L++;
                else if (sum > 10) R--;
            }
        }
        //Collections.sort(ans);
        return ans;
    }
}

