package SwordToOffer.NK1.findNumInMatrix;

/*
* ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
* ÿһ�ж����մ��ϵ��µ�����˳������
* �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
* */
public class Solution2 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        for (int i = 0;i<rows;i++){
            if (target >= array[i][0] && target <= array[i][cols-1]){
                for (int j = 0;j<cols;j++){
                    if (target == array[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
