package sort.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class quanPaiLie3 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(arr);
        /*int[] arrr = process(arr);
        for (int e : arrr){
            System.out.println(e);
        }*/
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        permute(0,8,arr,total,list);
        System.out.println(total);
    }

    private static void permute(int start, int target, int[] arr, ArrayList<ArrayList<Integer>> total,
                                ArrayList<Integer> list){
        if (target == 0){
            total.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i<arr.length;i++){
            /*if (i > 0 && arr[i] == arr[i-1]){
                continue;
            }*/
            list.add(arr[i]);
            permute(i+1,target-arr[i],arr,total,list);
            list.remove(list.size()-1);
        }
    }

    private static int[] process(int[] arr){
        int i = 0;
        int j = 1;
        while (j < arr.length){
            if (i+1 < arr.length && arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }else {
                j++;
            }
        }
        int[] ret = new int[i+1];
        for (int k = 0;k<ret.length;k++){
            ret[k] = arr[k];
        }
        return ret;
    }
}
