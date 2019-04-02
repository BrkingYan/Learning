package ThinkingInJava.Class;

public class Load {

    static final String LOADER = "loader";

    public static void main(String[] args) {
        Class class1 = Class1.class;
        System.out.println("get static final const " + Class1.staticFinalConst);//此时Class1类并未初始化
        System.out.println("----------------------------------------------");
        //第一次访问static final
        System.out.println("get static final none const " + Class1.staticFinalNotConst);//非编译期常量需要初始化后才能获取，因此会强制初始化
        System.out.println("----------------------------------------------");
        //第二次访问static final
        System.out.println("get static final none const " + Class1.staticFinalNotConst);
        System.out.println("----------------------------------------------");

        Class class2 = Class2.class;
        //第一次访问static
        System.out.println("get static " + Class2.staticNonFinal);
        System.out.println("----------------------------------------------");
        //第二次访问static
        System.out.println("get static " + Class2.staticNonFinal);
    }
}
