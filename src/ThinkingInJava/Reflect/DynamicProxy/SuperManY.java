package ThinkingInJava.Reflect.DynamicProxy;

public class SuperManY implements Man {
    @Override
    public void command(String people) {
        System.out.println("command method");
    }

    @Override
    public void speak() {
        System.out.println("speak method");
    }

    @Override
    public void speakString(String s) {
        System.out.println(s);
    }

    @Override
    public String getName() {
        return "yy";
    }
}
