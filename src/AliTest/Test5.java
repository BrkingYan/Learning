package AliTest;

import java.util.Scanner;

public class Test5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    private static int getMinimumTimeCost(int n, int[][] area) {
        int min = dfs(n,area,0,0);
        for (int i = 1;i<n;i++){
            int temp = dfs(n,area,0,i);
            min = Math.min(min,temp);
        }
        return min;
    }

    private static int dfs(int n, int[][] area,int row,int col) {
        int result = 0;
        if (row >= n){
            return result;
        }
        if (col >= n){
            return result;
        }
        if (col < n-3){
            result += Math.min(area[row+1][col] + dfs(n,area,row+2,col),
                    area[row][col+1] + dfs(n,area,row,col+2));
        }else {
            result += area[row+1][col] + dfs(n,area,row+2,col);
        }
        return result;
    }
}
