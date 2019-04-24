package SwordToOffer.NK41.FindContinuousSequence;

import java.util.*;


/*
*  ����
*
* ������к�ΪS�������������С�
* �����ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
*
*
* С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9--16�ĺ�,�����Ͼ�д������ȷ����100��
* ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
* û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
* */
class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (sum < 3){
            return totalList;
        }
        int limit = sum / 2;
        int low = 1;
        int high = 2;
        while (low < high){
            int subSum = (low + high) * (high-low+1) / 2;
            if (subSum == sum){
                ArrayList<Integer> innerList = new ArrayList<>();
                for (int i = low;i<=high;i++){
                    innerList.add(i);
                }
                totalList.add(innerList);
                low++;
            }else if (subSum < sum){
                high++;
            }else {
                low++;
            }
        }
        return totalList;
    }
}
