package SwordToOffer.NK53.isNumeric;


/*
* ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
* ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
* */
public class Solution {
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
