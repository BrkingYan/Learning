package sort;


/*
* ϣ�������Ǽ򵥲�������ĸĽ�
* */
public class ShellSort {
    public static void main(String[] args) {
        int[] arrr = new int[]{3,44,38,5,47};
        shellSort(arrr);
        for (int e : arrr){
            System.out.println(e);
        }
    }

    private static void shellSort(int[] arr){
        int len = arr.length;
        int temp;
        for (int gap = len/2;gap > 0;gap /= 2){
            for (int j = gap;j<len;j++){//���һ��ѭ��ֻ��Ҫ΢������
                if (arr[j] < arr[j-gap]){
                    temp = arr[j];
                    arr[j] = arr[j-gap];
                    arr[j-gap] = temp;
                }
            }
        }
    }

    private static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
