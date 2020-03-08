package A_Test_Bed;

import java.util.Arrays;

public class BigNum {
    public static void main(String[] args) {
        System.out.print(decrease("1230","55"));
    }

    private static String add(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int i = len1-1;
        int j = len2-1;
        int curSum = 0;
        int carry = 0;
        int a,b;
        StringBuilder res = new StringBuilder();
        while (i >=0 || j >= 0){
            if(i >= 0) {
                a = str1.charAt(i)-'0';
                i--;
            }else {
                a = 0;
            }

            if(j >= 0){
                b = str2.charAt(j)-'0';
                j--;
            }else{
                b = 0;
            }
            curSum = a + b + carry;
            if (curSum >= 10){
                curSum -= 10;
                carry = 1;
            }else {
                carry = 0;
            }
            res.append(curSum);
        }
        if (carry == 1){
            res.append(carry);
        }
        res.reverse();
        return res.toString();
    }

    private static String decrease(String str1,String str2){
        int i = str1.length()-1;
        int j = str2.length()-1;
        int borrow = 0;
        int a,b,cur;
        StringBuilder res = new StringBuilder();
        while (i >=0 || j>= 0){
            if (i >= 0){
                a = str1.charAt(i) - '0';
                i--;
            }else {
                a = 0;
            }

            if (j >= 0){
                b = str2.charAt(j) - '0';
                j--;
            }else {
                b = 0;
            }

            if (a-borrow >= b){
                cur = a - borrow - b;
                borrow = 0;
            }else {
                cur = 10 + a - borrow - b;
                borrow = 1;
            }
            res.append(cur);
        }
        res.reverse();
        return res.toString();
    }
}
