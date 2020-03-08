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
                throw new IllegalArgumentException("��������");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** ������������������ʵ����ĿҪ��Ĺ��� **/
    /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/

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
