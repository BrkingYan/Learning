package ThinkingInJava.InnerClass;


//局部内部类
public class Outer2 {
    public MyInterface getMyInterface(String s){
        class Inner2 implements MyInterface{
            private String ss;
            private Inner2(String s1){
                ss = s1;
            }

            @Override
            public void show() {
                System.out.println("hello");
            }
        }
        return new Inner2(s);//封装了实现，返回的是MyInterface类型
    }

    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        MyInterface myInterface = outer2.getMyInterface("123");
        myInterface.show();//有点类似适配器模式，原本是 Inner2的show()，现在变成了MyInterface的show()方法

    }/*new Outer(){
            int a = 0;

        };*/
}
