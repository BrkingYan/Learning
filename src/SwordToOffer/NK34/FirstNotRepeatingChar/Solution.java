package SwordToOffer.NK34.FirstNotRepeatingChar;


import java.util.ArrayList;
import java.util.List;

/*
* ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,
* ����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
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
