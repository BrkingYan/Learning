package SwordToOffer.NK32.PrintMinNumber;

import java.util.ArrayList;

/*
*  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
*  例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
* */
class Solution {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if (numbers.length == 0){
            return sb.toString();
        }

        if (numbers.length == 1){
            sb.append(numbers[0]);
            return sb.toString();
        }

        for (int i = 0;i<numbers.length;i++){
            list.add(numbers[i]+"");
        }

        for (int i = 0;i<list.size();i++){
            for (int j = i+1;j<list.size();j++){
                if (aShouldBeforeB(list.get(j),list.get(i))){
                    String temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        for (int i = 0;i<list.size();i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    boolean aShouldBeforeB(String a,String b){
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int aLength = aArray.length;
        int bLength = bArray.length;
        boolean aIsBigThanB;
        int minLength;


        if (aLength>bLength){
            minLength = bLength;
            aIsBigThanB = true;
        }else {
            minLength = aLength;
            aIsBigThanB = false;
        }

        if (aLength == bLength){
            if (aArray[0] < bArray[0]){
                return true;
            }
        }

        for (int i = 0;i<minLength;i++){
            if (aArray[i] > bArray[i]){
                return false;
            }
        }
        if (aIsBigThanB){ // aLength > bLength
            if (aArray[aLength-1] > bArray[0]){
                return false;
            }
            return true;
        }else {  //aLength <= bLength
            if (aLength == bLength){
                for (int i = 0;i<minLength;i++){
                    if (aArray[i] < bArray[i]){
                        return false;
                    }
                }
                return true;
            }else {  //aLength < bLength
                if (bArray[bLength-1] > aArray[0]){
                    return true;
                }
            }
            return false;
        }
    }
}
