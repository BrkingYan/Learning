package Design_Patterns.NO1_Ce_Hua_Mode2;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I cant quack");
    }
}
