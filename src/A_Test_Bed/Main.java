package A_Test_Bed;

import java.util.*;

public class Main {

    private static int count = 0;
    private static boolean[][] visited;
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int DynamicPathPlanning(int[][] matrixGrid) {
        int xLen = matrixGrid.length;
        int yLen = matrixGrid[0].length;
        /*visited = new boolean[xLen][yLen];
        dfs(matrixGrid,visited,0,0,xLen,yLen);
        return count;*/

        int[][] dp = new int[xLen][yLen];
        for (int i = 0; i < dp.length; i ++ ) {
            if(matrixGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i ++ ) {
            if(matrixGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i ++ ) {
            for (int j = 1; j < dp[0].length; j ++ ) {
                if(matrixGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private static void dfs(int[][] map,boolean[][] visited,int x,int y,int xLen,int yLen){
        if(x == xLen-1 && y == yLen-1 && map[x][y] != 1){
            count++;
            return;
        }
        if(x >= xLen || y >= yLen || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        dfs(map,visited,x+1,y,xLen,yLen);
        dfs(map,visited,x,y+1,xLen,yLen);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _matrixGrid_rows = 0;
        int _matrixGrid_cols = 0;
        _matrixGrid_rows = Integer.parseInt(in.nextLine().trim());
        _matrixGrid_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _matrixGrid = new int[_matrixGrid_rows][_matrixGrid_cols];
        for(int _matrixGrid_i=0; _matrixGrid_i<_matrixGrid_rows; _matrixGrid_i++) {
            for(int _matrixGrid_j=0; _matrixGrid_j<_matrixGrid_cols; _matrixGrid_j++) {
                _matrixGrid[_matrixGrid_i][_matrixGrid_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = DynamicPathPlanning(_matrixGrid);
        System.out.println(String.valueOf(res));

    }
}





