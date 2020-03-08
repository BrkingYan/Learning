package A_Test_Bed.SortTest2;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,6,5,4,1};
        int[] temp = new int[6];
        sort(arr,temp,0,arr.length-1);

        for (int e : arr){
            System.out.println(e);
        }
    }

    private static void sort(int[] arr,int[] temp,int start,int end){
        if (start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        sort(arr,temp,start,mid);
        sort(arr,temp,mid+1,end);
        merge(arr,temp,start,mid,end);
    }

    private static void merge(int[] arr,int[] temp,int start,int mid,int end){

        for (int i = start;i<=end;i++){
            temp[i] = arr[i];
        }

        int i = start;
        int j = mid+1;

        for (int k = start;k<=end;k++){
            if (i > mid){
                arr[k] = temp[j++];
            }else if (j > end){
                arr[k] = temp[i++];
            }else if (temp[i] < temp[j]){
                arr[k] = temp[i++];
            }else {
                arr[k] = temp[j++];
            }
        }
    }
}
