package ThinkingInJava.InnerClass;


//�ֲ��ڲ���
public class Outer2 {
    public MyInterface getMyInterface(String s){
        class Inner2 implements MyInterface{
            private String ss;
            private Inner2(String s1){
                ss = s1;
            }

            @Override
            public void show() {
                System.out.println("hello");
            }
        }
        return new Inner2(s);//��װ��ʵ�֣����ص���MyInterface����
    }

    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        MyInterface myInterface = outer2.getMyInterface("123");
        myInterface.show();//�е�����������ģʽ��ԭ���� Inner2��show()�����ڱ����MyInterface��show()����

    }/*new Outer(){
            int a = 0;

        };*/
}
