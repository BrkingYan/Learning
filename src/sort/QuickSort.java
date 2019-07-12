package sort;


import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.algs4.*;
/*
* 快速排序：
*
* 挖坑填数，最开始区间是0-4，不断缩小区间
* */
public class QuickSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{12,3,44,38,5,47,33,43,5};
        quickSort(arrr,0,arrr.length-1);

        for (int e: arrr){
            System.out.println(e);
        }
    }

    private static void quickSort(int[] arr,int start,int end){
        if (end <= start)
            return;
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);

    }

    /*
    *  该函数将数组以一个中间值(数组的第一个元素)切分为两半，前一半的元素都小于中间值，后一半的元素都大于中间值
    * */
    private static int partition(int[] arr,int start,int end){
        int leftPointer = start+1;

        int midIndex = 0;

        int rightPointer = end;
        int temp;
        int key = arr[start];//以第一个元素为key

        while (true){
            //leftPointer扫过的范围的数都比key小
            while (arr[leftPointer] < key){
                if (leftPointer == end)
                    break;
                leftPointer++;
            }
            //rightPointer扫过的范围的数都比key大
            while (arr[rightPointer] > key){
                if (rightPointer == start)
                    break;
                rightPointer--;
            }

            if (leftPointer >= rightPointer){
                midIndex = rightPointer;
                break;
            }else {
                midIndex = leftPointer;
                temp = arr[rightPointer];
                arr[rightPointer] = arr[leftPointer];
                arr[leftPointer] = temp;
                break;
            }
        }
        temp = arr[start];
        arr[start] = arr[midIndex];
        arr[midIndex] = temp;
        //swap(arr[start],arr[rightPointer]);
        return midIndex;

    }

    private static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
