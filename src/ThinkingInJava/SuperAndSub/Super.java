package ThinkingInJava.SuperAndSub;

public class Super {

    /*
    * 非静态field必须通过对象调用，因此会导致初始化
    * */
    public String value2 = "321";
    /*
    * 子类调用父类的static field，不会引发子类的初始化
    * */
    public static int value = 123;
    /*
    * 常量在编译阶段会存入类Super的常量池中
    * 在编译期，这个常量也会被存入ClassLoadTest类的常量池中
    * 因此不会触发类的初始化
    * */
    public static final String CONST = "const";

    static{
        System.out.println("super class is loaded");
    }
}
