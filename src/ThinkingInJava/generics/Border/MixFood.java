package ThinkingInJava.generics.Border;

public class MixFood extends Fruit implements Meal {
    @Override
    public void meal() {
        System.out.println("meal()");
    }
}
