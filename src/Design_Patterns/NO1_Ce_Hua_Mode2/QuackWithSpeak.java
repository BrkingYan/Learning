package Design_Patterns.NO1_Ce_Hua_Mode2;

public class QuackWithSpeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I am Quacking with a speaker");
    }
}
