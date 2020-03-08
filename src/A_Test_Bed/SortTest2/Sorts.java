package A_Test_Bed.SortTest2;

public class Sorts {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,6,5,2};
        shellSort(arr);
        for (int e : arr){
            System.out.println(e);
        }
    }


    private static void bubbleSort(int[] arr){
        for (int i = 0;i<arr.length;i++){
            for (int j = 1;j<arr.length;j++){
                if (arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }
    }

    private static void selectSort(int[] arr){
        int minIndex;
        for (int i = 0;i<arr.length;i++){
            minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    private static void insertSort(int[] arr){
        for (int i = 0;i<arr.length;i++){
            for (int j = i;j>0;j--){
                if (arr[j] < arr[j-1]){
                    swap(arr,j-1,j);
                }
            }
        }
    }

    private static void shellSort(int[] arr){
        int len = arr.length;
        for (int gap = len/2;gap>0;gap/=2){
            for (int i = gap;i<len;i++){
                if (arr[i] < arr[i-gap]){
                    swap(arr,i,i-gap);
                }
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
