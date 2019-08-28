package sort.Test;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,4,1,8,2};
        heapSort(arr);
        for (int e : arr){
            System.out.println(e);
        }
    }

    private static void heapSort(int[] arr){
        int start = arr.length / 2 - 1;
        while (start >= 0){
            siftDown(arr,start,arr.length);
            start--;
        }

        for (int i = arr.length-1;i>=0;i--){
            swap(arr,0,i);
            siftDown(arr,0,i);
        }
    }

    private static void siftDown(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;
        while (childIndex < N){
            if(childIndex+1 < N && arr[childIndex] < arr[childIndex+1]){
                childIndex++;
            }
            if(arr[childIndex] > parent){
                arr[i] = arr[childIndex];
                i = childIndex;
            }
            childIndex = 2 * childIndex + 1;
        }
        arr[i] = parent;
    }

    private static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
