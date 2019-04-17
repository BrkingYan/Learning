package MI_OJ.NO3.bigNum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        String num1;
        String num2;
        String[] string1s;
        String[] string2s;
        int[] num1s;
        int[] num2s;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] nums = line.split(" ");
            num1 = nums[0];
            num2 = nums[1];
            num1s = new int[num1.length()];
            num2s = new int[num2.length()];
            string1s = num1.split("");
            string2s = num1.split("");
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i<string1s.length;i++){
                num1s[i] = Integer.parseInt(string1s[i]);
            }

            for (int i = 0;i<string2s.length;i++){
                num2s[i] = Integer.parseInt(string2s[i]);
            }
            int borrow = 0;
            if (num1.length() > num2.length()){
                for (int i = 0;i<num2.length();i++){
                    if (num1s[i]-num2s[i]-borrow >= 0){
                        sb.append(num1s[i]-num2s[i]-borrow);
                        borrow = 0;
                    }else {
                        borrow = 1;

                    }
                }
            }
        }
    }
}

