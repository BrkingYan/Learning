package SwordToOffer.NK13.reOrderArray;


import java.util.ArrayList;

/*
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
* 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
* 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
* */
public class Solution2 {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0;i<array.length;i++){
            if (isOdd(array[i])){
                odd.add(array[i]);
            }else {
                even.add(array[i]);
            }
        }
        odd.addAll(even);
        for (int i = 0;i<array.length;i++){
            array[i] = odd.get(i);
        }
    }

    private boolean isOdd(int num){
        if (num % 2 == 0){
            return false;
        }
        return true;
    }
}
