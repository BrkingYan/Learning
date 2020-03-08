package Mr.Left.T10.max_min_num;

import java.util.LinkedList;

/*
* ���ֵ��ȥ��Сֵ <= num �������������������ʱ�临�Ӷ�Ҫ��Ϊ O(N)
* */
public class Solution {
    public int getSum(int[] arr,int sum){
        LinkedList<Integer> qmin = new LinkedList<>();//�ö��б�֤�ײ�����С�ģ�����������˸�С�ģ���ǰ��Ĵ��ȥ��
        LinkedList<Integer> qmax = new LinkedList<>();//�ö��б�֤�ײ������ģ�����������˸���ģ���ǰ���С��ȥ��
        int leftP = 0;
        int rightP = 0;
        int result = 0;
        while (leftP < arr.length){
            while (rightP < arr.length){
                while (!qmin.isEmpty() && arr[qmin.getLast()] >= arr[rightP]){
                    qmin.pollLast();
                }
                qmin.addLast(rightP);
                while (!qmax.isEmpty() && arr[qmax.getLast()] <= arr[rightP]){
                    qmax.pollLast();
                }
                qmax.addLast(rightP);
                // qmax.getFirst()���ǵ�ǰ�����е����ֵ
                // qmin.getFirst()���ǵ�ǰ�����е���Сֵ
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > sum){
                    break;
                }
                rightP++;
            }
            if (qmin.getFirst() == leftP){
                qmin.pollFirst();
            }
            if (qmax.getFirst() == leftP){
                qmax.pollFirst();
            }
            result += rightP - leftP;
            leftP++;
        }
        return result;
    }
}
