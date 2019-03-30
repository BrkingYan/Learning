package SwordToOffer.NK27.Permutation;

import java.util.*;

/*
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
* 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
*
* 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
* */
class Solution {
    public ArrayList<String> Permutation(String str) {
        int typeNum = 0;
        int length = str.length();
        char[] array = str.toCharArray();
        Set<Character> set = new HashSet<>();

        //PermutationHelper(array,set);
        //Collection<String> list = new ArrayList<>(set);
        //ArrayList<String> list1 = new ArrayList<>(list);
        return new ArrayList<>();

    }

    void PermutationHelper(char[] totalArray,Set<String> set){

    }
}
