package A_Recently;

/*
* 最长递增子序列
* */
public class max_incre_sub_list {
    private static int maxCnt = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,2};//1,3,4,8,9
        int[] dp = getDp1(arr);
        for (int e : dp){
            System.out.println(e+"...");
        }
        int[] ans = getOrder(dp,arr);
        for (int e : ans){
            System.out.print(e + " ");
        }
        System.out.println(getCount(dp));
    }

    private static int getCount(int[] dp){
        int max = dp[0];
        int maxIndex = 0;
        for (int i = 1;i<dp.length;i++){
            if (dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        //找到第二大的数
        int[] temp = new int[dp.length];
        System.arraycopy(dp,0,temp,0,dp.length);
        for (int k = 0;k < temp.length;k++){
            for (int m = 0;m < temp.length-1;m++){
                if (temp[m+1] < temp[m]){
                    swap(temp,m,m+1);
                }
            }
        }
        int second = 0;
        if (second == temp[temp.length-1]){
            return 0;
        }

        int count = 0;
        for (int i = 0;i < maxIndex;i++){
            if (dp[i] == second){
                count++;
            }
        }
        return count;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static int[] getDp1(int[] arr){
        //dp[i]表示以arr[i]结尾的数组的最长子序列的长度
        int[] dp = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            dp[i] = 1;
            int count = 0;
            for (int j = 0;j<i;j++){
                //所有比arr[i]小的都可能放在它的前一位
                if (arr[i] > arr[j]){
                    count++;
                    maxCnt = Math.max(maxCnt,count);
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }


    private static int[] getOrder(int[] dp,int[] arr){
        int len = 0;
        int index = 0;
        for (int i = 0;i<dp.length;i++){
            if (dp[i] > len){
                len = dp[i];
                index = i;
            }
        }
        int[] ans = new int[len];
        ans[--len] = arr[index];
        for (int i = index;i >= 0;i--){
            if (arr[i] < arr[index] && dp[i] == dp[index]-1){
                ans[--len] = arr[i];
                index = i;
            }
        }
        return ans;
    }
}
