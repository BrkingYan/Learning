package myTestBed;

import java.util.*;

public class Test{
    public static void main(String[] args) {
        String[] arr = new String[]{"i","love","leetcode","coding","love","i"};
        /*Arrays.sort(arr,(a,b)->(a.length()-b.length()));
        for (String s : arr){
            System.out.println(s);
        }*/
        System.out.println("abc".compareTo("lov"));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(4);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }



    private static void change(String s,char[] arr){
        System.out.println("inner s : " + s);
        s = "123";
        System.out.println(s);
        arr[0] = 'k';
    }

    private static void changeInt(int a){
        a = 6;
    }
}
