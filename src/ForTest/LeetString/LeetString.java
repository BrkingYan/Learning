package ForTest.LeetString;

/*
*   this program is used to find the longest sub String in the String s
* */
public class LeetString {
    public static void main(String[] args){
        String s = "123456123412345";
        char[] sArr = s.toCharArray();
        LeetString ls = new LeetString();
        int maxLength = ls.lengthOfLongestSubstring(s);
        System.out.println("maxLength is :" + maxLength);
        //System.out.println(sArr[7]);
    }


    public int lengthOfLongestSubstring(String s){
        char[] strArray = s.toCharArray();
        int i = 0;
        int maxLength = 1;
        int tempLength = 0;
        loop:while(i < s.length()){
            for (int j = i+1;j < s.length();j++){
                if (strArray[i] == strArray[j]){
                    tempLength = j - i;
                    if (tempLength > maxLength){
                        maxLength = tempLength;
                    }
                    if (maxLength >= s.length() - i){
                        break loop;
                    }
                    break ;
                }
                else if (j == s.length() - 1){
                    tempLength = j - i + 1;
                    if (tempLength > maxLength){
                        maxLength = tempLength;
                    }
                    if (maxLength >= s.length() - i){
                        break loop;
                    }
                    break ;
                }
            }
            i++;
        }
        return maxLength;
    }
}
