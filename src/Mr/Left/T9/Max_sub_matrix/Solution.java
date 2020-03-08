package Mr.Left.T9.Max_sub_matrix;


/*
* 给定一个整型数组map，其中的值只有0和1，
* 求其中全是1的所有矩形区域中，最大的矩形区域中1的数量
*
* 1 0 1 1
* 1 1 1 1
* 1 1 1 0
*
* */
public class Solution {
    public int getMaxSubMat(int[][] map){
        if (map.length == 0 || map[0].length == 0){
            return 0;
        }
        int rows = map.length;//行数
        int cols = map[0].length;//列数
        int[] height = new int[cols];
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                if (map[i][j] == 1){
                    height[j]++;
                }
            }
        }
        return 1;
    }
}
