package ThinkingInJava.Reflect.RTTI;

public class Test {
    public static void main(String[] args) {
        Interface1 obj = new A();//obj��ʼ��Interface1���ͣ�ֻ���øýӿ��еķ���
        obj.show1();
        //obj.show2();
        if (obj instanceof Interface1){
            A obj2 = (A)obj;//��objת��Ϊ�ӽӿ�A�����ܵ��øýӿ����еķ�����
            obj2.show2();
        }
    }
}
