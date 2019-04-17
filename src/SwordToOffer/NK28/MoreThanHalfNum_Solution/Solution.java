package SwordToOffer.NK28.MoreThanHalfNum_Solution;

import java.util.HashMap;
import java.util.Map;

/*
*  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
*  例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
*  由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
* */
class Solution {

    private class Entry implements Map.Entry<Integer,Integer>{
        int num;
        int count;
        Entry(int num,int count){
            this.num = num;
            this.count = count;
        }
        @Override
        public Integer getKey() {
            return num;
        }

        @Override
        public Integer getValue() {
            return count;
        }

        @Override
        public Integer setValue(Integer value) {
            count = value;
            return count;
        }
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length==1){
            return array[0];
        }
        Map<Integer,Entry> map = new HashMap<>();
        for (int i = 0;i<array.length;i++){
            if (!map.containsKey(array[i])){
                Entry entry = new Entry(array[i],1);
                map.put(array[i],entry);
            }else {
                Entry entry = map.get(array[i]);
                entry.count++;
                if (entry.count>array.length/2){
                    return entry.num;
                }
                map.put(array[i],entry);
            }
        }
        return 0;
    }
}
