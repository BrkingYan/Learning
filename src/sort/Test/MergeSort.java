package sort.Test;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,7,1,8,3};
        int[] temp  = new int[arr.length];
        sort(arr,temp,0,arr.length-1);
        for (int e:arr){
            System.out.println(e);
        }
    }

    private static void sort(int[] arr,int[] temp,int start,int end){
        if (start >= end) {
            return;
        }
        int mid = (start+ end)/2;
        sort(arr,temp,start,mid);
        sort(arr,temp,mid+1,end);
        merge(arr,temp,start,mid,end);
    }

    private static void merge(int[] arr,int[] temp,int start,int mid,int end){
        int leftP = start;
        int rightP = mid+1;
        for (int i = start;i<=end;i++){
            temp[i] = arr[i];
        }
        for (int i = start;i<=end;i++){
            if (leftP > mid){
                arr[i] = temp[rightP++];
            }else if (rightP > end){
                arr[i] = temp[leftP++];
            }else if (temp[leftP] > temp[rightP]){
                arr[i] = temp[rightP++];
            }else {
                arr[i] = temp[leftP++];
            }
        }
    }
}
