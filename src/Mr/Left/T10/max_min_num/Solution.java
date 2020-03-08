package Mr.Left.T10.max_min_num;

import java.util.LinkedList;

/*
* 最大值减去最小值 <= num 的所有子数组的数量，时间复杂度要求为 O(N)
* */
public class Solution {
    public int getSum(int[] arr,int sum){
        LinkedList<Integer> qmin = new LinkedList<>();//该队列保证首部是最小的，如果后面来了更小的，则将前面的大的去掉
        LinkedList<Integer> qmax = new LinkedList<>();//该队列保证首部是最大的，如果后面来了更大的，则将前面的小的去掉
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
                // qmax.getFirst()就是当前窗口中的最大值
                // qmin.getFirst()就是当前窗口中的最小值
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
