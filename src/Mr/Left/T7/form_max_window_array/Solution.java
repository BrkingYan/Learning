package Mr.Left.T7.form_max_window_array;

import java.util.LinkedList;

/*
*  已知一个数组和一个窗口
*  求不同窗口状态下，窗口中的最大值，将这些最大值装入一个数组中
*
*  要求 O(N)实现
*   window 3
*  [4,3,5,4,3,3,6,7]  [5,5,5,4,6,7]
*
*  使用双端队列实现
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

        //该队列中存放的是之前的index，队首是当前窗口中最大元素对应的index，往后依次递减，
        //队尾是当前窗口中最小元素对应的index
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
