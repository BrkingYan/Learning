package ThinkingInJava.Class;

import java.util.Random;

class Class1 {
    static final int staticFinalConst = 1;//编译期常量
    static final int staticFinalNotConst = new Random().nextInt(100);//非编译器常量
    static  {
        System.out.println("Class1 init");
    }
}
