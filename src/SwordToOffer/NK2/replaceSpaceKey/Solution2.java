package SwordToOffer.NK2.replaceSpaceKey;

/*
* ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
* ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
* */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                buffer.append('%');
                buffer.append('2');
                buffer.append('0');
            }else {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }
}
