package LeetCode._2.LongestSubStr;

/*
*  找出最长子串
* */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char leftP;
        char rightP;
        if (s.length() <= 1){
            return s.length();
        }

        char[] arr = s.toCharArray();
        leftP = 0;
        rightP = 0;
        int len = arr.length;
        int maxLen = 1;

        while (rightP < len-1){
            if (!findRange(arr,leftP,rightP,arr[rightP+1])){
                rightP++;
            }else {
                leftP++;
                if (leftP > rightP){
                    rightP = leftP;
                }
            }
            if (maxLen <= rightP - leftP){
                maxLen = rightP - leftP + 1;
            }
        }
        return maxLen;
    }

    private boolean findRange(char[] arr,int start,int end,char ch){
        for (int i = start;i <= end;i++){
            if (ch == arr[i]){
                return true;
            }
        }
        return false;
    }
}
