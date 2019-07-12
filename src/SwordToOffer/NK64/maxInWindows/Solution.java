package SwordToOffer.NK64.maxInWindows;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;


/*
* ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
* ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ�
* ���ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
* {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
* {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
* */
public class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0){
            return list;
        }
        if (size > num.length){
            return list;
        }
        if (size == num.length){
            list.add(getMaxVal(num,0,num.length-1));
        }else {
            for (int i = 0;i<=num.length-size;i++){
                list.add(getMaxVal(num,i,i+size-1));
            }
        }
        return list;
    }

    private int getMaxVal(int[] arr,int lo,int hi){
        int max = arr[lo];
        for (int i = lo+1;i<=hi;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
