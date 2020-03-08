package sort;

/*
* ð�����������Ƚ����ڼ�¼�Ĺؼ���,��������򽻻�
* ð������ʱ�临�Ӷ���õ����ΪO(n),��������O(n^2)
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
