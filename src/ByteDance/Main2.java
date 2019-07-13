package ByteDance;

import java.util.Scanner;
//1234567890
public class Main2 {
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(calTime(sc.nextLine()));
        }
    }

    private static int calTime(String str){
        int count = 0;
        int pointer = 0;
        char left = '5';
        char right = '6';
        char leftChar;
        char rightChar;
        char[] chars = str.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if (chars[i] == '0'){
                chars[i] = 'A';
            }
        }

        String str2 = new String(chars);
        while (pointer < str2.length()){
            leftChar = str2.charAt(pointer);
            if (pointer+1>=str2.length()){
                if (left == leftChar || right == leftChar){
                    count++;
                }else {
                    count += 2;
                }
                break;
            }
            rightChar = str2.charAt(pointer+1);
            if (leftChar < rightChar){
                int leftMove = Math.abs(leftChar - left);
                int rightMove = Math.abs(rightChar -right);
                left = leftChar;
                right = rightChar;
                if (leftChar == '5' && rightChar == '6'){
                    count += 2;
                }
                if (leftChar < '5'){
                    count += 3;
                }
            }else if (leftChar == rightChar){
                if (leftChar == '5' || leftChar == '6'){
                    count += 2;
                }else {
                    count += 3;
                }
            }else {
                left = rightChar;
                right = leftChar;
                if (leftChar == '6'){
                    count += 2;
                }else {
                    count += 3;
                }
            }
            if (pointer + 2 <= str2.length()){
                pointer += 2;
            }else {
                pointer++;
                if (left == str2.charAt(pointer) || right == str2.charAt(pointer)){
                    count++;
                }else {
                    count += 2;
                }
            }
        }
        return count;
    }

}
