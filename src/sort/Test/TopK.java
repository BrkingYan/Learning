package sort.Test;

public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,6,8,1,2,9,7};
        int[] ret = topKBubble(arr,3);
        for (int e : ret){
            System.out.println(e);
        }
    }

    private static int[] topKBubble(int[] arr,int k){
        int[] ret = new int[k];
        for (int i = 0;i<k;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    ret[k-i-1] = arr[arr.length-i-1];
                }
            }
        }
        return ret;
    }

    private static void swap(int[] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
