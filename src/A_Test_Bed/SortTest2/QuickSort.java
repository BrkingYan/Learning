package A_Test_Bed.SortTest2;

public class QuickSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{4,19,14,5,-3,1,8,5,11,15};
        sort(arrr,0,arrr.length-1);
        for (int e : arrr){
            System.out.println(e);
        }
    }

    private static void sort(int[] arr,int start,int end){
        if (start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        sort(arr,start,mid-1);
        sort(arr,mid+1,end);
    }

    private static int partition(int[] arr,int start,int end){
        int key = arr[start];
        int left = start+1;
        int right = end;

        while (true){
            while (arr[left] < key){
                if (left == end){
                    break;
                }
                left++;
            }

            while (arr[right] > key){
                if (right == start+1){
                    break;
                }
                right--;
            }

            if (left >= right){
                break;
            }else {
                swap(arr,left,right);
            }
        }
        swap(arr,start,right);
        return right;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
