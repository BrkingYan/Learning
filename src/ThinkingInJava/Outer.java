package ThinkingInJava;

public class Outer {
    void f(){
        System.out.println("Outer.f() run");
    }
    public class Inner{
        public Outer getOuter(){
            return Outer.this;
        }
    }


    public Inner getInner(){
        return new Inner();
    }

    public static void main(String[] args){
        Outer outer = new Outer();

        //从外部类中 new 出来的一个Inner对象
        Inner inner1 = outer.getInner();//inner1 is made from outer

        //两个从外部类中 new 出来的Inner对象 inner2 和 inner3
        Outer.Inner inner2 = outer.getInner();
        Outer.Inner inner3 = outer.getInner();
        // 由 .new格式创建Inner对象，而不是通过方法
        Outer.Inner inner4 = outer.new Inner();

        //由于这三个Inner对象都是 new 出来的，所以它们是不同的三个对象

        System.out.println("inner1 compare with inner2  " + inner1.equals(inner2));
        System.out.println("inner2 compare with inner3  " + inner2.equals(inner3));
        System.out.println("inner1 compare with inner4  " + inner1.equals(inner4));

        //三个从不同inner对象的getOuter()方法得到的Outer对象，得到的是同一个
        Outer outerFromInner1 = inner1.getOuter();
        Outer outerFromInner2 = inner2.getOuter();
        Outer outerFromInner3 = inner3.getOuter();

        System.out.println("outerFromInner1 compare with outerFromInner2  " + outerFromInner1.equals(outerFromInner2));
        System.out.println("outerFromInner2 compare with outerFromInner3  " + outerFromInner2.equals(outerFromInner3));

        System.out.println("outer compare with outerFromInner1  " + outer.equals(outerFromInner1));
        outerFromInner1.f();
    }
}
