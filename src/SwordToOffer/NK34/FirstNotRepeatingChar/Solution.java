package SwordToOffer.NK34.FirstNotRepeatingChar;


import java.util.ArrayList;
import java.util.List;

/*
* 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
* 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
* */
class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        List<Character> checkedList = new ArrayList<>();
        for (int i = 0;i<chars.length;i++){
            list.add(chars[i]);
        }
        for (int i = 0;i<list.size();i++){
            char ch = list.get(i);
            List<Character> newList = list.subList(i+1,list.size());
            if ((!newList.contains(ch)) && !checkedList.contains(ch)){
                return i;
            }
            checkedList.add(ch);
        }
        return -1;
    }
}
