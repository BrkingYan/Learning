package sort.Review;

import java.util.*;
import java.io.*;
public class Main1{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        int count = 0;
        char[] arr = line.toCharArray();
        for (int i = 0;i<arr.length;i++){
            if (arr[i] == '?'){
                arr[i] = '0';
            }
        }
        if (arr[0] == '0'){
            arr[0] = '1';
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        long min = Long.parseLong(sb.toString());

        arr = line.toCharArray();
        for (int i = 0;i<arr.length;i++){
            if (arr[i] == '?'){
                arr[i] = '9';
            }
        }
        sb.delete(0,sb.length());
        sb.append(arr);
        long max = Long.parseLong(sb.toString());
        long start = (min + 5) / 13;
        long temp;
        while (true){
            temp = start * 13 + 5;
            if (temp >= min && temp <= max){
                count++;
                count = count % 1000000007;
                start++;
            }else if (temp > max){
                break;
            }
        }
        System.out.println(count);
    }
}