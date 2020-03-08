package A_Recently;

import java.util.*;

public class Envelope2 {
    public static void main(String[] args) {
        Envelope2 e = new Envelope2();
        /*
        *  5个箱子，w、l、h分别为每个箱子的宽和长
        * */
        int[] w = new int[]{1,2,3,3,0};
        int[] l = new int[]{2,5,3,6,0};
        int[] h = new int[]{4,4,2,3,18};
        System.out.println(e.getHeight(w,l,h,w.length));
    }

    public int getHeight(int[] w, int[] l, int[] h, int n) {
        int[][] box = new int[n][3];
        for(int i = 0;i<n;i++){
            box[i][0] = w[i];
            box[i][1] = l[i];
            box[i][2] = h[i];
        }
        Arrays.sort(box,(a,b)->(b[0] == a[0] ? (b[1]-a[1]) : (b[0]-a[0])));
        for (int i = 0;i<box.length;i++){
            for (int j = 0;j<box[0].length;j++){
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }

        return getHeight(box);
    }

    private int getHeight(int[][] box){
        //dp[i] 表示从0到i的最大高度
        int[] dp = new int[box.length];
        for(int i = 0;i<dp.length;i++){
            dp[i] = box[i][2];
            for(int j = 0;j<i;j++){
                if(box[i][1] < box[j][1] && box[i][0] < box[j][0]){
                    dp[i] = Math.max(dp[i],dp[j]+box[i][2]);
                }
            }
        }
        return dp[box.length-1];
    }
}
