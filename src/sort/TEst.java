package sort;

public class TEst {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,1,6};
        quickSort(arr,0,arr.length-1);
        for (int e:arr){
            System.out.println(e);
        }
    }
    private static void quickSort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);
    }

    private static int partition(int[] arr,int start,int end){
        int leftP = start+1;
        int rightP = end;
        int key = arr[start];
        int temp;
        while(true){
            while(arr[leftP] < key){
                if(leftP == end){
                    break;
                }
                leftP++;
            }
            while(arr[rightP] > key){
                if(rightP == start){
                    break;
                }
                rightP--;
            }
            if(leftP < rightP){
                temp = arr[leftP];
                arr[leftP] = arr[rightP];
                arr[rightP] = temp;
            }else{
                break;
            }
        }
        temp = arr[start];
        arr[start] = arr[rightP];
        arr[rightP] = temp;

        return rightP;
    }
}
