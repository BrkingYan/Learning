package SwordToOffer.NK27.Permutation;

import java.util.*;

public class Solution2 {
    private static int count;

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        full_permutation(str.toCharArray(),0,str.length()-1,list);
        System.out.println(list);
        return list;
    }


    private void full_permutation(char[] str, int begin, int end,ArrayList<String> list) {
        if (begin == end) {
            count++;//此处可以输出字符串或者记录字符串
            list.add(String.valueOf(str));
        } else {
            int i;
            for (i = begin; i <= end; i++) {
                if (should_swap(str, begin, i)) {
                    swap(str, begin, i);
                    full_permutation(str, begin + 1, end,list);
                    swap(str, begin, i);
                }
            }
        }
    }

    /*
    *  返回的flag表示是否需要交换 begin 和 k 位置的元素
    *
    *  判断从子串的第一个字符串开始，直到k-1位置，是否有重复的字符
    * */

    /*
     * 对abb，第一个数a与第二个数b交换得到bab，
     * 然后考虑第一个数与第三个数交换(bba)的情况
     * 由于开始第三个数等于第二个数，所以第一个数就不用再与第三个数交换了(因为后面包括了这种情况)。
     * 再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
     *
     * (1<->2) && (2<->3) == (1<->3)
     * */
    private boolean should_swap(char[] str, int begin, int k) {
        int i;
        boolean flag;
        for (i = begin, flag = true; i < k; i++) {
            if (str[i] == str[k]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void swap(char[] arr, int lo, int hi) {
        char temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

    public static void main(String[] args) {
        new Solution2().Permutation("abb");
    }
}
