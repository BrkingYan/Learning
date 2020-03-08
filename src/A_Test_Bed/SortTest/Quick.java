package A_Test_Bed.SortTest;

public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,4,8,6};
        sort(arr,0,arr.length-1);

        for (int e : arr){
            System.out.print(e);
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

            while (rightP > start){
                if (arr[rightP] > key){
                    rightP--;
                }else {
                    break;
                }
            }

            if (leftP >= rightP){
                break;
            }else {
                swap(arr,leftP,rightP);
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
