package sort;

public class MergeSort {
    private static int[] temp;

    public static void main(String[] args) {
        int[] arrr = new int[]{4,19,14,5,-3,1,8,5,11,15};
        temp = new int[arrr.length];
        mergeSort(arrr);
    }

    private static void mergeSort(int[] arr){
        int len = arr.length;
        int[] result = new int[len];
        sort(arr,result,0,len-1);

        for (int e: arr){
            System.out.println(e);
        }
    }

    /*
     * 将数组arr中 start到end的元素排序
     * */
    private static void merge(int[] arr,int[] temp,int start,int fence,int end){
        int leftPointer = start;
        int rightPointer = fence+1;


        //这一步复制操作很重要
        for (int i = start;i<=end;i++){
            temp[i] = arr[i];
        }

        /*
        *  先判断越界情况
        * */
        for (int k = start;k<=end;k++){
            if (rightPointer > end)
                arr[k] = temp[leftPointer++];
            else if (leftPointer > fence)
                arr[k] = temp[rightPointer++];
            else if (temp[leftPointer] < temp[rightPointer])
                arr[k] = temp[leftPointer++];
            else
                arr[k] = temp[rightPointer++];
        }
        System.out.println(makeSpace(end-start) + start + "--" + end + " is merged");
    }

    private static void sort(int[] arr,int[] temp,int start,int end){
        System.out.println(makeSpace(end-start) + "start sort " + start + "--" + end);
        if (start < end){
            int middle = (start + end) / 2;
            sort(arr,temp,start,middle);//将左半边排序
            sort(arr,temp,middle+1,end);//将右半边排序
            merge(arr,temp,start,middle,end);//将左右合并
        }
        System.out.println(makeSpace(end-start) + start + "--" + end + " is sorted");
    }

    private static String makeSpace(int n){
        StringBuilder sb = new StringBuilder();
        int count = 6-n;
        while (count > 0){
            sb.append(" ");
            count--;
        }
        return sb.toString();
    }
}
