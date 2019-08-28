package SwordToOffer.NK32.PrintMinNumber;

import java.util.*;
public class Solution2{
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                String str1 = String.valueOf(num1);
                String str2 = String.valueOf(num2);
                String link1 = str1 + str2;
                String link2 = str2 + str1;
                int val1 = Integer.valueOf(link1);
                int val2 = Integer.valueOf(link2);
                if (val1 > val2){
                    return 1;
                }else if (val1 < val2){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        StringBuilder s = new StringBuilder();
        for (int e : list){
            s.append(e);
        }
        return s.toString();
    }
}
