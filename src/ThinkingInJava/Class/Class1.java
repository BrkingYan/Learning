package ThinkingInJava.Class;

import java.util.Random;

class Class1 {
    static final int staticFinalConst = 1;//�����ڳ���
    static final int staticFinalNotConst = new Random().nextInt(100);//�Ǳ���������
    static  {
        System.out.println("Class1 init");
    }
}
