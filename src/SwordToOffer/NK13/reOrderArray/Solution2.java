package SwordToOffer.NK13.reOrderArray;


import java.util.ArrayList;

/*
* ����һ���������飬ʵ��һ�����������������������ֵ�˳��
* ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
* ����֤������������ż����ż��֮������λ�ò��䡣
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
