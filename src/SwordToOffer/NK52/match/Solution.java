package SwordToOffer.NK52.match;


/*
* ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
* ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����Ǹ��ַ����Գ�������Σ�����0�Σ���
* �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
* ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
* */
public class Solution {
    public boolean match(char[] str, char[] pattern) {

        if (str.length == 0){
            if (pattern.length == 0){
                return true;
            }else if (pattern.length == 2 && pattern[1] == '*'){
                return true;
            }
            if (pattern[0] == '*'){
                return true;
            }else {
                return false;
            }
        }else {
            if (pattern.length == 0){
                return false;
            }
        }

        int len = maxLen(str,pattern);
        char odd;
        int strP = 0;
        int patternP = 0;
        while (strP < str.length && patternP < pattern.length){
            if (str[strP] == pattern[patternP]){
                strP++;
                patternP++;
            }else {
                odd = str[strP];
                if (pattern[patternP] == '.'){
                    patternP++;
                    strP++;
                    continue;
                }else {
                    patternP++;
                    if (pattern[patternP] == '*'){
                        strP++;
                        patternP++;
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }
        if (strP >= str.length && patternP < pattern.length){
            if (pattern[patternP] == '*' && patternP == pattern.length-1){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }

    private int maxLen(char[] a,char[] b){
        int aLen = a.length;
        int bLen = b.length;
        if (aLen>bLen)
            return aLen;
        else
            return bLen;
    }
}
