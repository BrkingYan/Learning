package SwordToOffer.NK44.ReverseSentence;

/*
*ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
* ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
* ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
* ��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
* */
class Solution {
    public String ReverseSentence(String str) {
        String[] strings = str.split(" ");
        if (strings.length==0){
            return str;
        }
        for (int i = 0;i<strings.length/2;i++){
            String temp = strings[i];
            strings[i] = strings[strings.length-i-1];
            strings[strings.length-i-1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<strings.length-1;i++){
            sb.append(strings[i]);
            sb.append(" ");
        }
        sb.append(strings[strings.length-1]);
        return sb.toString();
    }
}
