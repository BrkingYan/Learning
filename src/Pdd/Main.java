package Pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int sMin = 0;

        int n = sc.nextInt();
        //if(n <= 0 || n > 50){
        //throw new ArrayIndexOutOfBoundException("数组数量不在规定范围内");
        //}
        int[] sArray = new int[n*n];
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        //if(a.length!=n){
        //throw new ArrayIndexOutOfBoundException("数组a的数量不对");
        //}
        for(int j = 0; j < n; j++){
            b[j] = sc.nextInt();
        }
        //if(b.length()!=n){
        //throw new ArrayIndexOutOfBoundException("数组b的数量不对");
        //}
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0;i<n;i++){
            sMin += a[i] * b[n-i-1];
        }
        System.out.println(sMin);
    }
}
