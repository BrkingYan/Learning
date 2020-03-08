package A_Test_Bed.SortTest;

public class Merge {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,4,8,6};
        int[] temp = new int[arr.length];
        sort(arr,temp,0,arr.length-1);
        for (int e : arr){
            System.out.print(e);
        }
    }

    private static void sort(int[] arr,int[] temp,int start,int end){
        if (start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
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

        for (int k = start;k<=end;k++){
            if (leftP > mid){
                arr[k] = temp[rightP++];
            }else if (rightP > end){
                arr[k] = temp[leftP++];
            }else if (arr[leftP] < arr[rightP]){
                arr[k] = temp[leftP++];
            }else {
                arr[k] = temp[rightP++];
            }
        }
    }
}
