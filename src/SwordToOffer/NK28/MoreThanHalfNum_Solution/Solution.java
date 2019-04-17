package SwordToOffer.NK28.MoreThanHalfNum_Solution;

import java.util.HashMap;
import java.util.Map;

/*
*  ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
*  ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
*  ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
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
