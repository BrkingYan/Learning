package SwordToOffer.NK50.duplicate;

public class Soltuion2 {
    public static void main(String[] args) {
        Soltuion2 s = new Soltuion2();

    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int max = findMax(numbers);
        int[] count = new int[max+1];
        int res = 0;
        int[] result = new int[1];
        for(int i = 0;i<numbers.length;i++){
            count[numbers[i]]++;
            if(count[numbers[i]] == 2){
                res = numbers[i];
                result[0] = res;
                return true;
            }
        }
        return false;
    }

    private int findMax(int[] arr){
        int max = arr[0];
        if(arr.length == 1){
            return max;
        }
        for(int i = 1;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
