package ThinkingInJava.Class;

public class Load {

    static final String LOADER = "loader";

    public static void main(String[] args) {
        Class class1 = Class1.class;
        System.out.println("get static final const " + Class1.staticFinalConst);//��ʱClass1�ಢδ��ʼ��
        System.out.println("----------------------------------------------");
        //��һ�η���static final
        System.out.println("get static final none const " + Class1.staticFinalNotConst);//�Ǳ����ڳ�����Ҫ��ʼ������ܻ�ȡ����˻�ǿ�Ƴ�ʼ��
        System.out.println("----------------------------------------------");
        //�ڶ��η���static final
        System.out.println("get static final none const " + Class1.staticFinalNotConst);
        System.out.println("----------------------------------------------");

        Class class2 = Class2.class;
        //��һ�η���static
        System.out.println("get static " + Class2.staticNonFinal);
        System.out.println("----------------------------------------------");
        //�ڶ��η���static
        System.out.println("get static " + Class2.staticNonFinal);
    }
}
