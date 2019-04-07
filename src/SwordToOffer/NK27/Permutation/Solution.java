package SwordToOffer.NK27.Permutation;

import java.util.*;

/* 全排列
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
* 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
*
* 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
* */
class Solution {
    public ArrayList<String> Permutation(String str) {
        char[] charArray = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        if (str.equals("")){
            return list;
        }else {
            PermutationHelper(charArray,0,list);
            System.out.println(list);
            Collections.sort(list);
            System.out.println(list);
            return list;
        }
    }

    private void PermutationHelper(char[] charArray, int deep,ArrayList<String> list){
        if (deep == charArray.length){
            String line = String.valueOf(charArray);
            if (!list.contains(line)){
                list.add(line);
            }
        }else {
            for (int j = deep;j < charArray.length;j++){
                swap(charArray,j,deep);
                PermutationHelper(charArray,deep+1,list);
                swap(charArray,j,deep);
            }
        }
    }

    private void swap(char[] charArray, int first, int second){
        char temp = charArray[first];
        charArray[first] = charArray[second];
        charArray[second] = temp;
    }
}
