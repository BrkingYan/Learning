package A_Tencent;

import java.util.*;
import java.io.*;
public class Main3{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0;i<n;i++){
            list.add(reader.readLine());
        }

        char[] arr = new char[]{'A','S','D','F','G','H'};
        backTrack(arr,0,total);

        for (String s : list){
            for (String p : total){
                minCount = Math.min(minCount,process(s,p));
            }
            System.out.println(minCount);
            minCount = Integer.MAX_VALUE;
        }

    }

    private static List<String> total = new ArrayList<>();
    private static int minCount = Integer.MAX_VALUE;

    private static int process(String input,String pattern){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0;i<pattern.length();i++){
            map.put(pattern.charAt(i),i);
        }
        int count = 0;
        count += map.get(input.charAt(0));
        for (int i = 1;i<input.length();i++){
            char ch1 = input.charAt(i);
            char ch2 = input.charAt(i-1);
            count += (Math.abs(map.get(ch1) - map.get(ch2)));
        }
        return count;
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
