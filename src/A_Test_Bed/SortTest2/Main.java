package A_Test_Bed.SortTest2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
* 2.33.128.9
2.33.128.0/24
* */
public class Main {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {
        if (userIP.equals(blackIP)){
            return false;
        }
        int maskLen = 0;
        if ((maskLen = isRange(blackIP)) != -1){
            String user = toBinary(userIP);
            String black = toBinary(blackIP);
            for (int i = 0;i<maskLen;i++){
                if (user.charAt(i) != black.charAt(i)){
                    return true;
                }
            }
            return false;
        }else {
            return true;
        }
    }

    public static String toBinary(String ip){
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        if (isRange(ip) == -1){
            String[] sArray = ip.split("\\.");
            for (String ss : sArray){
                sb.append(help(Integer.parseInt(ss)));
            }
        }else {
            String[] sArray = ip.split("\\.");
            for (int i = 0;i<3;i++){
                sb.append(help(Integer.parseInt(sArray[i])));
            }
            int len = isRange(ip);
            while (sb.length() < len){
                sb.append(0);
            }
        }
        return sb.toString();
    }

    private static String help(int num){
        if (num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0){
            int cur = num % 2;
            sb.append(cur);
            num /= 2;
        }
        return sb.toString();
    }

    private static int isRange(String black){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < black.length()){
            if (black.charAt(i) == '/'){
                int j = i+1;
                while (j < black.length()){
                    sb.append(black.charAt(j));
                    j++;
                }
                return Integer.parseInt(sb.toString());
            }
            i++;
        }
        return -1;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}



