package ThinkingInJava.Reflect.DynamicProxyCGLIB;

class CGLIBTest {
    public static void main(String[] args) {
        MyIntercepter intercepter =  new MyIntercepter();
        Person proxy = (Person) intercepter.getProxy(Person.class);
        proxy.sayHello();
        proxy.sayOthers("123");
    }
}
