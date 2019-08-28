package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,4,6,2};
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(a-b));
        for (int e : arr){
            heap.add(e);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!heap.isEmpty()){
            list.add(heap.poll());
        }
        System.out.println(list);

        String ss = "asggfhd";
        int[] count = new int[256];
        for (int i = 0;i<ss.length();i++){
            count[ss.charAt(i)]++;
        }
        int[] clo = count.clone();
        Arrays.sort(count);
        for (int i = 0;i<count.length;i++){
            System.out.print(count[i]);
            //System.out.print(clo[i]);
        }
        System.out.println();
        for (int i = 0;i<count.length;i++){
            //System.out.print(count[i]);
            System.out.print(clo[i]);
        }
    }
}
