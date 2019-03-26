package ThinkingInJava.InnerClass;


//一般内部类Demo
class Outer {
    private class Inner{
        private String desc;
        private Inner(String innerString){
            desc = innerString;
        }

        public Outer getOuter(){
            return Outer.this;
        }
    }

    private Inner getInner(String desc){
        return new Inner(desc);
    }



    public static void main(String[] args) {
        //方式1
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner("123");
        String desc = inner.desc;
        //方式2
        Outer outer1 = new Outer();
        Outer.Inner inner1 = outer1.getInner("123");

        Outer.Inner inner2 = inner1.getOuter().getInner("123");
    }

    /*
    *  成员方法中不能有静态变量，方法中的变量都是临时的，和方法一样在堆栈中，当方法执行完弹栈后，变量销毁
    *  而static变量在方法区中，是共享的
    * */
    /*void print(){
        static int a = 1;
    }*/


    /*
    *  static 关键字是用来修饰类中成员的
    * */

    /*
    *  静态方法中也不能有静态变量，因为他也是一个方法，
    *  方法执行完后弹栈，内部变量也会销毁
    * */
    /*static void print1(){
        int a = 1;
        static int b = 2;
    }*/
}
