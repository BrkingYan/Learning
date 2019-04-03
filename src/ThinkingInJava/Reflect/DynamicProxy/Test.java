package ThinkingInJava.Reflect.DynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        ChairSpeaker chairMan = new ChairSpeaker();
        chairMan.speak();
        System.out.println();
        System.out.println("-------------------------------------------");

        Man man = (Man) Proxy.newProxyInstance(
                ChairSpeaker.class.getClassLoader(),
                new Class[]{Speaker.class,Leader.class},
                new Handler(chairMan));
        man.speak();
        System.out.println("-------------------------------------------");
        man.speakString("hello world ");
        System.out.println("-------------------------------------------");
        man.getName();
        System.out.println("-------------------------------------------");
        man.command("mike");
    }
}
