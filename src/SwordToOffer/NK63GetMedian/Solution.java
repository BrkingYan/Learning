package SwordToOffer.NK63GetMedian;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

/*
* ��εõ�һ���������е���λ����������������ж�����������ֵ��
* ��ô��λ������������ֵ����֮��λ���м����ֵ��
* ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
* ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
* */
public class Solution {
    //private DataInputStream stream = new DataInputStream();
    private List<Double> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num.doubleValue());
    }

    public Double GetMedian() {
        sort(list);
        if (list.size() % 2 != 0){
            return list.get((list.size()-1)/2);
        }else {
            return (list.get(list.size()/2-1) + list.get(list.size()/2))/2;
        }
    }
    //��������
    public void sort(List<Double> list){
        double temp;
        for (int i = 0;i<list.size()-1;i++){
            for (int j = i+1;j>0;j--){
                if (list.get(j-1) > list.get(j)){
                    temp = list.get(j-1);
                    list.set(j-1,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }

}
