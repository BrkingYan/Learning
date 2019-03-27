package ThinkingInJava.InnerClass.InnerOverwrite;

import edu.princeton.cs.algs4.Out;

public class Test {
    public static void main(String[] args) {

        /*
        *  对于非静态内部类
        * */
        BigOuter bigOuter = new BigOuter();
        BigOuter.Inner biginner = bigOuter.new Inner();//BigOuter$Inner 这个内部类叫 BigOuter.Inner 他只能被其外围类的对象创建，不能被其外围类的子类创建
        //Outer.Inner innerCreatedByBigOuter = bigOuter.new Inner(); 这句话有问题
        biginner.show();

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();//Outer$Inner  这个内部类叫 Outer.Inner 他只能被其外围类的对象创建
        inner.show();

        // outer.new Inner()只能创建 Outer.inner实例对象
        //BigOuter.Inner x = outer.new Inner();
        //只有当子类获取了其父类的对象之后，才能创建其父类的内部类对象
        BigOuter.Inner x = outer.getObject().new Inner();
        x.show();

        //BigOuter$Inner 与 Outer$Inner是两个独立的类

        /**********************************************************/
        System.out.println("***********************************************");
        /*
        * 对于嵌套类的对象创建，则不依赖外围类对象，可以在任何地方创建对象
        * */

        BigOuter.StaticInner bigStaticInner = new BigOuter.StaticInner();//BigOuter.StaticInner
        bigStaticInner.show();

        Outer.StaticInner staticInner = new Outer.StaticInner();//Outer.StaticInner
        staticInner.show();






    }
}
