package ThinkingInJava.InnerClass.ExtendsAInner;

class Outer {
    private String name = "hh";

    public class Inner{
        int id = 1;
        Outer outer = Outer.this;
        void show(){
            System.out.println("show()");
        }
    }
}
