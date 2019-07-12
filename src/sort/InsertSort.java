package sort;


/*
* 插入排序: 在要排序的一组数中，假定前n-1个数已经排好序，
* 现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 时间复杂度也为O(n^2), 比冒泡法和选择排序的性能要更好一些
 *
 * 将后一个元素往前面已经排序好的序列里面插入
 * */
public class InsertSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47};
        insertSort(arrr);
    }

    private static void insertSort(int[] arr){
        int len = arr.length;
        int temp;
        for (int i =0 ;i<len-1;i++){
            for (int j = i+1;j>0;j--){
                //相邻交换
                if (arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        for (int e : arr){
            System.out.println(e);
        }
    }
}
