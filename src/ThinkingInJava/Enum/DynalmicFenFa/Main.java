package ThinkingInJava.Enum.DynalmicFenFa;


/*
*  javaֻ֧�ֶ�̬���ַ�(��������ʱ��ʵ�����͵��ַ�)��ֻ���Ƿ�����������
* */
public class Main {
    public static void main(String[] args) {
        String s1 = "ab"; //s1��String����
        Object o = s1 +"c";//oʵ������String����
        String s = "abc";
        System.out.println(o.equals(s));//����o��ʵ��������String����˵��õ���String��equals()��������˱Ƚϵ�������
        System.out.println(o == s);//false
        System.out.println(o.getClass().getSimpleName());//String
    }

}
