package SwordToOffer.NK45.isContinuous;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,9,4,5};
        System.out.println(new Solution2().isContinuous(arr));
    }
    public boolean isContinuous(int [] numbers) {
        sort(numbers);
        int zeroCount = 0;
        for(int i = 0;i<numbers.length;i++){
            if(numbers[i] == 0){
                zeroCount++;
            }
        }
        int needs = 0;
        int temp = 0;
        for(int i = zeroCount;i<numbers.length-1;i++){
            temp = numbers[i+1] - numbers[i] - 1;
            needs += temp;
        }
        if(needs <= zeroCount){
            return true;
        }
        return false;
    }

    private void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private void quickSort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int mid = partition(arr,start,end);
        quickSort(arr,start,mid-1);
        quickSort(arr,mid+1,end);
    }

    private int partition(int[] arr,int start,int end){
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
