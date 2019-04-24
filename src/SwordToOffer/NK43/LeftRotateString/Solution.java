package SwordToOffer.NK43.LeftRotateString;

/*
*  �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
*  �������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ������������
*  ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
* */
class Solution {
    public String LeftRotateString(String str, int n) {
        int strLength = str.length();
        String headStr;
        String tailStr;
        if (strLength == 0){
            return str;
        }
        if (n < strLength) {
            headStr = str.substring(n);
            tailStr = str.substring(0, n);
        } else {
            headStr = str.substring(n % strLength);
            tailStr = str.substring(0, n % strLength);
        }
        return headStr + tailStr;
    }
}
