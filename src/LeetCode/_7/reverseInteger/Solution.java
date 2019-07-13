package LeetCode._7.reverseInteger;



public class Solution {
    public int reverse(int x) {

        if (x == 0){
            return 0;
        }

        boolean isNegtive = false;
        String str = String.valueOf(x);
        if (str.charAt(0) == '-'){
            isNegtive = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1;i > 0;i--){
            sb.append(str.charAt(i));
        }
        if (!isNegtive){
            sb.append(str.charAt(0));
        }

        if (sb.charAt(0) == '0'){
            for (int i = 0;i<sb.length();i++){
                if (sb.charAt(0) == '0'){
                    sb.delete(0,1);
                }else {
                    break;
                }
            }
        }


        long result = Long.parseLong(sb.toString());
        if (result > Integer.MIN_VALUE && result < Integer.MAX_VALUE){
            if (isNegtive){
                return -1 * Integer.parseInt(sb.toString());
            }
            return Integer.parseInt(sb.toString());
        }
        return -1;
    }

}
