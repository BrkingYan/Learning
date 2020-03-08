package sort.Review;



import java.util.*;

/*
* 数组中多个数的乘积能否构成目标值，可重复利用元素
* */
public class Muti {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5};
        Arrays.sort(arr);
        System.out.println(minCount);
    }


    private static int minCount = Integer.MAX_VALUE;
    //把钱恰好花光，购买的最少商品数
    private static void dfs(int[] arr, int target){
        LinkedList<Integer> stack = new LinkedList<>();
        int count = 0;
        int leftMoney = target;
        int i = arr.length-1;
        while (i >= 0){
            if (leftMoney >= arr[i]){
                leftMoney -= arr[i];
                count++;
                stack.push(arr[i]);
            }else if (leftMoney == 0){
                count++;
                minCount = Math.min(minCount,count);
            }
        }

    }
}
