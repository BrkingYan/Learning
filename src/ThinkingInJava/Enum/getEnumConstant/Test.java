package ThinkingInJava.Enum.getEnumConstant;

public class Test {
    public static void main(String[] args) {
        //class��getEnumConstannts()����ֻ�ܸ�ö������ʹ��
        System.out.println(Person.class.getEnumConstants());
        System.out.println(Color.class.getEnumConstants());
    }
}
