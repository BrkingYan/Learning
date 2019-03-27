package ThinkingInJava.InnerClass.InnerOverwrite;

class Outer extends BigOuter{
    class Inner{
        void show(){
            System.out.println("Outer.Inner.show()");
        }
    }

    static class StaticInner{
        void show(){
            System.out.println("Outer.StaticInner.show()");
        }
    }
}
