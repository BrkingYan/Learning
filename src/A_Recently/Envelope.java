package A_Recently;

import java.util.*;
public class Envelope{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr,(a,b)->(a[0] == b[0] ? (b[1]-a[1]) : (a[0]-b[0]) ));
        int[] temp = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            temp[i] = arr[i][1];
        }
        int[] dp = getDp(temp);
        int len = dp[0];
        for(int i = 1;i<dp.length;i++){
            if(dp[i] > len){
                len = dp[i];
            }
        }
        System.out.println(len);
    }

    private static int[] getDp(int[] arr){
        int[] dp = new int[arr.length];
        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }

}
