package Mr.Left.T9.Max_sub_matrix;


/*
* ����һ����������map�����е�ֵֻ��0��1��
* ������ȫ��1�����о��������У����ľ���������1������
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
        int rows = map.length;//����
        int cols = map[0].length;//����
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
