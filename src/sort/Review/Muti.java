package sort.Review;



import java.util.*;

/*
* �����ж�����ĳ˻��ܷ񹹳�Ŀ��ֵ�����ظ�����Ԫ��
* */
public class Muti {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5};
        Arrays.sort(arr);
        System.out.println(minCount);
    }


    private static int minCount = Integer.MAX_VALUE;
    //��Ǯǡ�û��⣬�����������Ʒ��
    private static void dfs(int[] arr, int target){
        LinkedList<Integer> stack = new LinkedList<>();
        int count = 0;
        int leftMoney = target;
        int i = arr.length-1;
        while (i >= 0){
            if (leftMoney >= arr[i]){
                leftMoney -= arr[i];
                count++;
                stack.push(arr[i]);
            }else if (leftMoney == 0){
                count++;
                minCount = Math.min(minCount,count);
            }
        }

    }
}
