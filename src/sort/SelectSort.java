package sort;


/*
* 选择排序：维护一个minIndex，开始时指向第一个元素，然后将余下未排序的各元素与minIndex指向的元素比较
*           如果比minIndex指向的元素小，就让minIndex指向更小的，最终minIndex将指向未未排序序列的最小值
*           将这个最小值和之前的最新排序好的元素互换
* 时间复杂度也为O(n^2)
*
*
* */
public class SelectSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47};
        selectSort(arrr);
    }

    private static void selectSort(int[] arr){
        int len = arr.length;
        int minIndex;
        int temp;
        for (int i = 0;i<len;i++){
            minIndex = i;
            for (int j = i+1;j<len;j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int e:arr){
            System.out.println(e);
        }
    }

    private static void selectSortOptimization(int[] arr){
        int len = arr.length;
        int minIndex;
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
        }
        for (int i = 0;i<len;i++){
            minIndex = i;
            for (int j = i+1;j<len;j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int e:arr){
            System.out.println(e);
        }
    }
}
