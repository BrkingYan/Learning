package sort.Review;

import java.util.ArrayList;

public class quanPaiLie2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        permute(0,arr,total,list);
        System.out.println(total);
    }

    private static void permute(int start,int[] arr, ArrayList<ArrayList<Integer>> total,ArrayList<Integer> list){
        for (int i = start;i<arr.length;i++){
            if (i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            total.add(new ArrayList<>(list));
            permute(i+1,arr,total,list);
            list.remove(list.size()-1);

        }
    }
}
