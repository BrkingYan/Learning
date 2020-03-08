package sort.Review;

import java.util.*;
import java.util.List;

public class quanPaiLie {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<LinkedList<Integer>> total = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        permute(arr,0,total,queue);
        System.out.println(total);
    }

    private static void permute(int[] arr,int start,List<LinkedList<Integer>> total,LinkedList<Integer> queue){

        if (queue.size() == arr.length){
            total.add(new LinkedList<>(queue));
            return;
        }

        for (int i = start;i<arr.length;i++){
            queue.add(arr[i]);
            permute(arr,i+1,total,queue);
            queue.removeLast();
        }
    }
}
