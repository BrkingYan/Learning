package SwordToOffer.NK19.printMatrix;

import java.util.ArrayList;
import java.util.List;

/*
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
* 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
* 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
* */
class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int flag;
        int flag1 = 1;
        int flag2 = 2;
        int flag3 = 3;
        int flag4 = 4;
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        int completeFlag1 = 0;
        int completeFlag2 = 0;
        int completeFlag3 = 0;
        int completeFlag4 = 0;
        int count = 0;
        flag = flag1;
        while (count < rowNum * columnNum){
            switch (flag){
                case 1:
                    for (int i = completeFlag4;i < columnNum-completeFlag2;i++){
                        System.out.println(matrix[completeFlag1][i]);
                        count ++;
                    }
                    completeFlag1++;
                    flag = flag2;
                    break;
                case 2:
                    for (int i = completeFlag2;i < matrix.length-completeFlag1-completeFlag3;i++){
                        System.out.println(matrix[i+completeFlag1][columnNum-completeFlag2-1]);
                        count ++;
                    }
                    completeFlag2 ++;
                    flag = flag3;
                    break;
                case 3:
                    for (int i = columnNum-completeFlag2;i > completeFlag4;i--){
                        System.out.println(matrix[rowNum-completeFlag2][i]);
                        count ++;
                    }
                    completeFlag3 ++;
                    flag = flag4;
                    break;
                case 4:
                    for (int i = columnNum-1;i > 0;i--){
                        System.out.println(matrix[rowNum-completeFlag1-completeFlag3][completeFlag3-1]);
                        count ++;
                    }
                    completeFlag3 ++;
                    flag = flag1;
                    break;
            }
        }
        return list;
    }
}
