package SwordToOffer.NK47.Sum_Solution;

import java.util.Arrays;
import java.util.HashSet;

/*
* ��1+2+3+...+n��
* Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
* */
class Solution {
    public int Sum_Solution(int n) {
        int sum = (int)Math.pow(n,2) + n;
        return sum>>1;
    }
}
