package A_Test_Bed;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{3,4},{2,3},{4,5},{1,3},{2,2},{3,6},{1,2},{3,2},{2,4}};
        Arrays.sort(mat,(a,b)->(a[0] == b[0] ? (b[1]-a[1]) : (a[0]-b[0])));
        printMat(mat);
    }

    private static void printMat(int[][] mat){
        for (int i = 0;i<mat.length;i++){
            for (int j = 0;j<mat[0].length;j++){
                System.out.println(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
