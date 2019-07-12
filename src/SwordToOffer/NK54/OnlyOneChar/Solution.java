package SwordToOffer.NK54.OnlyOneChar;


/*
* ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
* ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
* ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
*
* �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ�
*
* */
public class Solution {
    private int[] count = new int[256];
    private StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        if (count[ch] == 0){
            count[ch] = 1;
        }else {
            count[ch] += 1;
        }

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] chars = sb.toString().toCharArray();
        for (char c : chars){
            if (count[c] == 1){
                return c;
            }
        }
        return '#';

    }
}
