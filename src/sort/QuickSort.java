package sort;


import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.algs4.*;
/*
* ��������
*
* �ڿ��������ʼ������0-4��������С����
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
    *  �ú�����������һ���м�ֵ(����ĵ�һ��Ԫ��)�з�Ϊ���룬ǰһ���Ԫ�ض�С���м�ֵ����һ���Ԫ�ض������м�ֵ
    * */
    private static int partition(int[] arr,int start,int end){
        int leftPointer = start+1;

        int midIndex = 0;

        int rightPointer = end;
        int temp;
        int key = arr[start];//�Ե�һ��Ԫ��Ϊkey

        while (true){
            //leftPointerɨ���ķ�Χ��������keyС
            while (arr[leftPointer] < key){
                if (leftPointer == end)
                    break;
                leftPointer++;
            }
            //rightPointerɨ���ķ�Χ��������key��
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
