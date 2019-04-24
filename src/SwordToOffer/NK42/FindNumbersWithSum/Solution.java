package SwordToOffer.NK42.FindNumbersWithSum;

import java.util.*;

/*
*  滑窗
*
* 输入一个递增排序的数组和一个数字S，
* 在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
*
* 对应每个测试案例，输出两个数，小的先输出。
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
