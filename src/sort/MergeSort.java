package sort;

public class MergeSort {
    private int[] temp;

    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47,12};
        //temp = new
        mergeSort(arrr);
    }

    private static void mergeSort(int[] arr){
        int len = arr.length;
        int[] result = new int[len];
        sort(arr,result,0,len-1);

        for (int e: result){
            System.out.println(e);
        }
    }

    // temp数组在慢慢改变，最后就会变成排序好的数组
    private static void merge(int[] arr,int[] temp,int start,int fence,int end){
        int leftPointer = start;
        int rightPointer = fence+1;

        for (int k = start;k<=end;k++){
            if (leftPointer > fence)
                arr[k] = temp[rightPointer++];
            else if (rightPointer > end)
                arr[k] = temp[leftPointer++];
            else if (temp[rightPointer] < temp[leftPointer])
                arr[k] = temp[rightPointer++];
            else
                arr[k] = temp[leftPointer++];
        }
    }

    private static void sort(int[] arr,int[] temp,int start,int end){

        if (start < end){
            int middle = (start + end) / 2;
            sort(arr,temp,start,middle);
            sort(arr,temp,middle+1,end);
            merge(arr,temp,start,middle,end);
        }
    }
}
