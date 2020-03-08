package Mr.Left.T7.form_max_window_array;

import java.util.LinkedList;

/*
*  ��֪һ�������һ������
*  ��ͬ����״̬�£������е����ֵ������Щ���ֵװ��һ��������
*
*  Ҫ�� O(N)ʵ��
*   window 3
*  [4,3,5,4,3,3,6,7]  [5,5,5,4,6,7]
*
*  ʹ��˫�˶���ʵ��
* */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int[] re = solution(arr,3);
        for (int e:re){
            System.out.println(e);
        }
    }
    public static int[] solution(int[] arr,int len){
        if (arr == null || len == 0 || arr.length < len){
            return null;
        }
        int[] result = new int[arr.length - len + 1];

        //�ö����д�ŵ���֮ǰ��index�������ǵ�ǰ���������Ԫ�ض�Ӧ��index���������εݼ���
        //��β�ǵ�ǰ��������СԪ�ض�Ӧ��index
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0;i<arr.length;i++){
            while (!queue.isEmpty() && arr[queue.getLast()] <= arr[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.getFirst() == i - len){
                queue.pollFirst();
            }
            if (i >= len-1){
                result[index++] = arr[queue.getFirst()];
            }
        }
        return result;
    }
}
