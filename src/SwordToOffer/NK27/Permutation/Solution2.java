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
            count++;//�˴���������ַ������߼�¼�ַ���
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
    *  ���ص�flag��ʾ�Ƿ���Ҫ���� begin �� k λ�õ�Ԫ��
    *
    *  �жϴ��Ӵ��ĵ�һ���ַ�����ʼ��ֱ��k-1λ�ã��Ƿ����ظ����ַ�
    * */

    /*
     * ��abb����һ����a��ڶ�����b�����õ�bab��
     * Ȼ���ǵ�һ�����������������(bba)�����
     * ���ڿ�ʼ�����������ڵڶ����������Ե�һ�����Ͳ��������������������(��Ϊ����������������)��
     * �ٿ���bab�����ĵڶ���������������������Խ��bba����ʱȫ����������ϣ�
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
