package sort.Test;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,4,2};
        quickSort(arr,0,arr.length-1);
        for (int e : arr){
            System.out.println(e);
        }
    }

    private static void quickSort(int[] arr,int start,int end){
        if (start >= end ){
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);
    }

    private static int partition(int[] arr,int start,int end){
        int key = arr[start];
        int leftP = start+1;
        int rightP = end;
        while (true){
            while (leftP < end){
                if (arr[leftP] < key){
                    leftP++;
                }else {
                    break;
                }
            }
            while (rightP >= start){
                if (arr[rightP] > key){
                    rightP--;
                }else {
                    break;
                }
            }
            if(leftP < rightP){
                swap(arr,leftP,rightP);
            }else {
                break;
            }
        }
        swap(arr,start,rightP);
        return rightP;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
