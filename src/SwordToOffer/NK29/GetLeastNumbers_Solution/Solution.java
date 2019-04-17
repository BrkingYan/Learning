package SwordToOffer.NK29.GetLeastNumbers_Solution;

import java.util.ArrayList;
import java.util.Collections;

/*
* ����n���������ҳ�������С��K������
* ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
* */
class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || k<=0 || input.length==0){
            return list;
        }

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        Collections.sort(list);


        for (int i = k;i<input.length;i++){
            if (input[i] < list.get(k-1)){
                list.add(input[i]);
                Collections.sort(list);
                list.remove(k);
            }
        }
        return list;
    }
}
