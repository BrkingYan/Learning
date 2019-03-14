package SwordToOffer.NK13.reOrderArray;

/*
*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
* 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
* */


import java.util.ArrayList;
import java.util.List;

class Solution {
    public void reOrderArray(int [] array) {
        List oddList = new ArrayList();
        List evenList = new ArrayList();
        for (int element : array){
            if (element % 2 == 0){
                evenList.add(element);
            }else {
                oddList.add(element);
            }
        }
        oddList.addAll(evenList);
        for (int i = 0;i < oddList.size();i++){
            array[i] = (int)oddList.get(i);
        }
    }
}
