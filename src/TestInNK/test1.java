package TestInNK;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine().trim());
        String current;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        int i = 0;
        while (i < N){
            current = sc.nextLine();
            list.add(current);
            i++;
        }
        for (String s : list){
            result.add(modifyStringFor2(modifyStringFor3(s)));
        }
        for (String s : result){
            System.out.println(s);
        }
    }

    private static String modifyStringFor3(String s){
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        int dupTimes;
        int i = 0;
        while (i<arr.length){
            dupTimes = dupNum(arr,i);
            if (dupTimes >= 2){
                for (int j = dupTimes;j>1;j--){
                    sb.setCharAt(i+j,' ');
                }
                i += dupTimes+1;
                continue;
            }
            i++;
        }
        sb = delteZero(sb);
        return sb.toString().trim();
    }

    private static String modifyStringFor2(String s){
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        int dupTimes;
        int tempTimes1 = 0;
        int tempTimes2 = 0;
        int i = 0;
        while (i<arr.length){
            tempTimes1 = 0;
            tempTimes2 = 0;
            dupTimes = dupNum(arr,i);
            if (dupTimes == 1){
                if (i+2 < arr.length){
                    tempTimes1 = dupNum(arr,i+2);
                }
                if (tempTimes1 == 1){
                    if (i+4 < arr.length){
                        tempTimes2 = dupNum(arr,i+4);
                    }
                    if (tempTimes2 == 1){
                        sb.setCharAt(i+3,' ');
                        i += 6;
                        continue;
                    }else if (tempTimes2 > 1){
                        sb.setCharAt(i+3,' ');
                        i += 5;
                    }else {

                    }
                }
            }
            i++;
        }
        sb = delteZero(sb);
        return sb.toString().trim();
    }


    private static int dupNum(char[] chars,int index){
        char dup = chars[index];
        int dupTimes = 0;
        for (int i = index+1;i<chars.length;i++){
            if (chars[i] != dup){
                break;
            }
            dupTimes++;
        }
        return dupTimes;
    }

    private static StringBuilder delteZero(StringBuilder sb){
        int i = 0;
        while (i<sb.length()){
            if (sb.charAt(i) == ' '){
                sb.delete(i,i+1);
                continue;
            }
            i++;
        }
        return sb;
    }
}
