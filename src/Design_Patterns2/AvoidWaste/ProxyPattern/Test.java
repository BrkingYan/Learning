package Design_Patterns2.AvoidWaste.ProxyPattern;

public class Test {
    public static void main(String[] args) {
        Image image = new ProxyImage("hello.png");
        image.display();

        image.display();
    }
}
