package SwordToOffer.NK42.FindNumbersWithSum;

import java.util.*;

/*
*  ����
*
* ����һ����������������һ������S��
* �������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
*
* ��Ӧÿ�����԰����������������С���������
* */
class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int lowPointer = 0;
        int highPointer = array.length-1;
        int maxDistance = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (lowPointer < highPointer){
            if (array[lowPointer] + array[highPointer] == sum){
                int distance = highPointer-lowPointer;
                if (maxDistance < distance){
                    maxDistance = distance;
                    list.clear();
                    list.add(array[lowPointer]);
                    list.add(array[highPointer]);
                }
                highPointer--;
            }else if (array[lowPointer] + array[highPointer] < sum){
                lowPointer++;
            }else {
                highPointer--;
            }
        }
        return list;
    }
}
