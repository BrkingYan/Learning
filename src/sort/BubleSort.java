package sort;

/*
* 冒泡排序：两两比较相邻记录的关键字,如果反序则交换
* 冒泡排序时间复杂度最好的情况为O(n),最坏的情况是O(n^2)
* */
public class BubleSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47};
        bubleSort(arrr);
    }

    private static void bubleSort(int[] arr){
        int len = arr.length;
        int temp;
        for (int i = 0;i<len;i++){
            for (int j = 0;j<len-1;j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int e:arr){
            System.out.println(e);
        }
    }

    private static void bubleSortOptimization(int[] arr){
        int len = arr.length;
        int temp;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int j = 1;j<len;j++){
                if (arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
        }
        for (int i = 0;i<len;i++){

        }
        for (int e:arr){
            System.out.println(e);
        }
    }
}
