package Redis;

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,5,4};
        System.out.println(findKthLargest(arr,2));
        for(int e : arr){
            System.out.println(e);
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        heapSort(nums);
        return nums[k-1];
    }

    private static void heapSort(int[] arr){
        int start = arr.length / 2 -1;
        //¹¹½¨Ð¡¶¥¶Ñ
        while(start >= 0){
            siftUp(arr,start,arr.length);
            start--;
        }

        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i);
            siftUp(arr,0,i);
        }

    }


    private static void siftUp(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;
        while(childIndex < N){
            if(childIndex+1 < N && arr[childIndex] > arr[childIndex+1]){
                childIndex++;
            }
            if(arr[childIndex] < parent){
                arr[i] = arr[childIndex];
                i = childIndex;
            }else{
                break;
            }
            childIndex = 2 * childIndex + 1;
        }
        arr[i] = parent;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
