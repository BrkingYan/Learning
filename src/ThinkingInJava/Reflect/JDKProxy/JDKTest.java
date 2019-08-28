package ThinkingInJava.Reflect.JDKProxy;

public class JDKTest {
    public static void main(String[] args) {
        MyIntercepter intercepter = new MyIntercepter();
        Person person = new Person();
        Man man = (Man) intercepter.getProxy(person);
        man.sayHello();
    }
}
