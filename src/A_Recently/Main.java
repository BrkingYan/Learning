package A_Recently;
public class Main{
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,6,2,4,9};
        process(arr);
        for (int e : arr){
            System.out.print(e);
        }
    }
//1£¬5£¬3£¬6£¬2£¬4£¬9
    private static void process(int[] arr){
        int oddIdx = 0;
        int i = 0;
        while (i < arr.length){
            int cur = arr[i];
            if (cur % 2 != 0){
                oddIdx = i+1;
            }else {
                for (int k = i;k>oddIdx;k--){
                    swap(arr,k,k-1);
                }
            }
            i++;
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}