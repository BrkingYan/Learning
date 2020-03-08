package sort.Test;

public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,6,8,1,2,9,7};
        //int[] ret = topKBubble(arr,3);
        int[] ret = topKHeap(arr,3);
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

    private static int[] topKHeap(int[] arr,int k){
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = arr[i];
        }

        int start = k / 2 -1;
        //形成小顶堆
        while (start >= 0){
            adjust(res,start,k);
            start--;
        }

        for (int i = k;i<arr.length;i++){
            if (arr[i] < res[0]){
                res[0] = arr[i];
                adjust(res,0,k);
            }
        }
        return res;
    }


    /*
    * 形成大顶堆
    * */
    private static void adjust(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;
        while (childIndex < N){
            if (childIndex+1 < N && arr[childIndex+1] > arr[childIndex]){
                childIndex++;
            }
            if (arr[childIndex] > parent){
                arr[i] = arr[childIndex];
                i = childIndex;
            }else {
                break;
            }
            childIndex = 2 * childIndex + 1;
        }
        arr[i] = parent;
    }
}
