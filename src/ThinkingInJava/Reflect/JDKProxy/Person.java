package ThinkingInJava.Reflect.JDKProxy;

public class Person implements Man {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
