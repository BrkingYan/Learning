package ThinkingInJava.SuperAndSub;

public class Super {

    /*
    * �Ǿ�̬field����ͨ��������ã���˻ᵼ�³�ʼ��
    * */
    public String value2 = "321";
    /*
    * ������ø����static field��������������ĳ�ʼ��
    * */
    public static int value = 123;
    /*
    * �����ڱ���׶λ������Super�ĳ�������
    * �ڱ����ڣ��������Ҳ�ᱻ����ClassLoadTest��ĳ�������
    * ��˲��ᴥ����ĳ�ʼ��
    * */
    public static final String CONST = "const";

    static{
        System.out.println("super class is loaded");
    }
}
