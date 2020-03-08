package SwordToOffer.NK19.printMatrix;


/*
* ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
* ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
* �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
* */
import java.util.ArrayList;
class Solution2 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int raws = matrix.length;
        int cols = matrix[0].length;
        addNumCirclely(matrix,0,raws-1,0,cols-1,result);
        return result;
    }

    private void addNumCirclely(int[][] matrix,int startRow,int endRow,int startCol,int endCol,ArrayList<Integer> result){
        if (startRow < endRow && startCol < endCol){
            //right
            for (int i = startCol;i<=endCol;i++){
                result.add(matrix[startRow][i]);
            }
            //down
            for (int j = startRow+1;j<=endRow-1;j++){
                result.add(matrix[j][endCol]);
            }
            //left
            for (int i = endCol;i>=startCol;i--){
                result.add(matrix[endRow][i]);
            }
            //up
            for (int j = endRow-1;j>=startRow+1;j--){
                result.add(matrix[j][startCol]);
            }
            addNumCirclely(matrix,startRow+1,endRow-1,startCol+1,endCol-1,result);
        }else if (startRow < endRow && startCol == endCol){
            for (int i = startRow;i<=endRow;i++){
                result.add(matrix[i][startCol]);
            }
        }else if (startRow == endRow && startCol < endCol){
            for (int i = startCol;i<=endCol;i++){
                result.add(matrix[i][startRow]);
            }
        }else if (startRow == endRow && startCol == endCol){
            result.add(matrix[startRow][startCol]);
        }
    }
}
