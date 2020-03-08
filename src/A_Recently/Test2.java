package A_Recently;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        Test2 t = new Test2();
        System.out.println(t.getPermutation("123"));
    }

    public ArrayList<String> getPermutation(String A) {
        char[] arr = A.toCharArray();
        ArrayList<String> total = new ArrayList<>();
        backTrack(arr,0,total);
        return total;
    }

    private void backTrack(char[] arr,int start,ArrayList<String> total){
        if (start == arr.length){
            StringBuilder sb = new StringBuilder();
            sb.append(arr);
            total.add(sb.toString());
        }
        for(int i = start;i<arr.length;i++){
            swap(arr,start,i);
            backTrack(arr,start+1,total);
            swap(arr,start,i);
        }
    }

    private void swap(char[] arr,int i , int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
