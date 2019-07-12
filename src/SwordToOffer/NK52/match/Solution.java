package SwordToOffer.NK52.match;


/*
* 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
* 模式中的字符'.'表示任意一个字符，而'*'表示它前面的那个字符可以出现任意次（包含0次）。
* 在本题中，匹配是指字符串的所有字符匹配整个模式。
* 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
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
