package A_Tencent;

import Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory.Link;

import java.util.*;

public class BackTrack {
    public static void main(String[] args) {
        char[] arr = new char[]{'a','b','c'};
        List<String> total = new ArrayList<>();
        backTrack(arr,0,total);
        System.out.println(total);
    }

    private static void backTrack(char[] arr, int start, List<String> total){
        if (start == arr.length){
            total.add(new String(arr));
            return;
        }

        for (int i = start;i<arr.length;i++){
            swap(arr,i,start);
            backTrack(arr,start+1,total);
            swap(arr,i,start);
        }
    }

    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
