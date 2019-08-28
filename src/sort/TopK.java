package sort;

public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,9,5,7,1,2,2};
        //System.out.println(find(arr,3));

        //int[] re = topKBubble(arr,3);
        //int[] re = topKHeap(arr,3);
        //int[] re = topKHeap(arr,3);

        int[] re = topKHeap2(arr,6);
        for (int e : re){
            System.out.println(e);
        }
    }

    /*
     *  找出数组中第一个出现n次的数
     * */
    private static int find(int[] arr,int n){
        int max = 0;
        for (int i = 0;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int[] count = new int[max+1];
        for (int i = 0;i<arr.length;i++){
            count[arr[i]]++;
            if (count[arr[i]] == n){
                return arr[i];
            }
        }
        return -1;
    }

    /*
    *  topK 找出数组中前k大的数，冒泡法
    * */
    private static int[] topKBubble(int[] arr,int k){
        int[] result = new int[k];
        int temp,i;
        for (int j = 0;j<k;j++){
            for (i = j;i<arr.length-1;i++){
                if (arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            result[j] = arr[arr.length-j-1];
        }
        return result;
    }

    /*
     *  topK 找出数组中前k大的数，堆排序法
     * */
    private static int[] topKHeap(int[] arr,int k){
        int[] result = new int[k];
        int start = arr.length / 2 - 1;
        //构建大顶堆
        while (start >= 0){
            sink(arr,start,arr.length);
            start--;
        }

        for (int i = 0;i<k;i++){
            result[i] = arr[0];
            swap(arr,0,arr.length-1-i);
            sink(arr,0,arr.length-1-i);
        }
        return result;
    }

    private static void sink(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;

        while (childIndex < N){
            if (childIndex+1 < N && arr[childIndex] < arr[childIndex+1]){
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

    /*
    * topK 找出数组中前k小的数，堆排序法
    * */
    private static int[] topKHeap2(int[] arr,int k){
        //构建小顶堆
        int start = arr.length / 2 - 1;
        while (start >= 0){
            floatUp(arr,start,arr.length);
            start--;
        }

        int[] result = new int[k];
        for (int i = 0;i<k;i++){
            result[i] = arr[0];
            swap(arr,0,arr.length-1-i);
            floatUp(arr,0,arr.length-1-i);
        }
        return result;
    }

    /*
    * 该方法保证 arr中 i 到 N 的范围内是小顶堆
    * */
    private static void floatUp(int[] arr,int i,int N){
        int parent = arr[i];
        int childIndex = 2 * i + 1;
        while (childIndex < N){
            if (childIndex+1 < N && arr[childIndex] > arr[childIndex+1]){
                childIndex++;
            }
            if (arr[childIndex] < parent){
                arr[i] = arr[childIndex];
                i = childIndex;
            }else {
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
