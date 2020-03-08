package A_Test_Bed.SortTest2;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,4,1};
        sort(arr);
        for (int e : arr){
            System.out.println(e);
        }
    }

    private static void sort(int[] arr){
        int start = arr.length / 2 - 1;
        while (start >= 0){
            adjust(arr,start,arr.length);
            start--;
        }

        for (int i = arr.length-1;i>0;i--){
            swap(arr,0,i);
            adjust(arr,0,i);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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
