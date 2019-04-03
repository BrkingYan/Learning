package ThinkingInJava.Reflect.RTTI;

public class Test {
    public static void main(String[] args) {
        Interface1 obj = new A();//obj开始是Interface1类型，只能用该接口中的方法
        obj.show1();
        //obj.show2();
        if (obj instanceof Interface1){
            A obj2 = (A)obj;//将obj转型为子接口A，就能调用该接口特有的方法了
            obj2.show2();
        }
    }
}
