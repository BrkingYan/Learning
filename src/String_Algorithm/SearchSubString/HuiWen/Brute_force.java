package String_Algorithm.SearchSubString.HuiWen;

import java.util.ArrayList;

public class Brute_force {
    public String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }

        if (s.length() > 1000){
            return null;
        }

        char[] arr = s.toCharArray();
        int len = arr.length;
        int left;
        int right;
        int maxLen;
        String currentMax = null;
        ArrayList<String> allThePalindrome = new ArrayList<>();
        for (left=0;left<len;left++){
            for (right = left;right < len;right++){
                if (isPalindrome(arr,left,right)){
                    if (currentMax == null){
                        currentMax = s.substring(left, right + 1);
                    }else if (currentMax.length() < s.substring(left,right+1).length()){
                        currentMax = s.substring(left, right + 1);
                    }
                }
            }
        }
        return currentMax;
    }

    private boolean isPalindrome(char[] arr,int start,int end){
        int leftP = start;
        int rightP = end;
        while (leftP <= rightP){
            if (arr[leftP] != arr[rightP]){
                return false;
            }
            leftP++;
            rightP--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
        System.out.println(new Brute_force().longestPalindrome(s));
        char[] arr = s.toCharArray();
        System.out.println(new Brute_force().isPalindrome(arr,1,3));
    }
}
