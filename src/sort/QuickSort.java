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
        int[] arrr = new int[]{4,19,14,5,-3,1,8,5,11,15};
        quickSort(arrr,0,arrr.length-1);

        for (int e: arrr){
            System.out.println(e);
        }
    }

    /*
    * 排序的思想：将当前数组切分，然后分别将左右两部分进行排序
    *             当切分到只剩一个元素时，直接返回(只有一个元素是不能切分的)
    *             当切分到只剩两个元素时，可以切分
    * */
    private static void quickSort(int[] arr,int start,int end){
        System.out.println("begin sort "+ start + "--" + end);
        //如果end  == start，说明只有一个元素，就直接返回
        if (end <= start){
            System.out.println("end sort " + start + "--" + end);
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);
        System.out.println("end sort " + start + "--" + end);
    }

    /*
    *  该函数将数组以一个中间值(数组的第一个元素)切分为两半，前一半的元素都小于中间值，后一半的元素都大于中间值
    * */
    private static int partition(int[] arr,int start,int end){
        System.out.println("begin partition " + start + "--" + end);
        int leftPointer = start+1;

        int rightPointer = end;
        int temp;
        int key = arr[start];//以第一个元素为key

        while (true){
            //leftPointer扫过的范围的数都比key小
            //一直搜寻到比key大的值，或者最后一个元素为止
            while (arr[leftPointer] < key){
                if (leftPointer == end)
                    break;//到末尾就退出
                //否则继续往后搜
                leftPointer++;
            }
            //rightPointer扫过的范围的数都比key大
            //一直搜寻到比key小的值或者第一个元素
            while (arr[rightPointer] > key){
                if (rightPointer == start)
                    break;//到最前端就退出
                //否则继续往前搜
                rightPointer--;
            }

            if (leftPointer >= rightPointer){//如果左右指针划过的范围存在交集，这时两指针一定相邻
                //midIndex = rightPointer;//那么中心点就是右指针的位置
                //这时候才算切分完全成功了
                break;
            }
            //否则的话，说明还没切分完全，左右指针还隔很远，
            //因此，将两指针指向的数据互换，继续执行上面的操作。
            temp = arr[rightPointer];
            arr[rightPointer] = arr[leftPointer];
            arr[leftPointer] = temp;
        }
        /*
        * 将start与rightIndex互换
        * */
        temp = arr[start];
        arr[start] = arr[rightPointer];
        arr[rightPointer] = temp;
        //swap(arr[start],arr[rightPointer]);
        System.out.println("end partition " + start + "--" + end);
        return rightPointer;
    }

    private static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
