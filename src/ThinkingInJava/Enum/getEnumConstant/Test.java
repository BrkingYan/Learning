package ThinkingInJava.Enum.getEnumConstant;

public class Test {
    public static void main(String[] args) {
        //class的getEnumConstannts()方法只能给枚举类型使用
        System.out.println(Person.class.getEnumConstants());
        System.out.println(Color.class.getEnumConstants());
    }
}
