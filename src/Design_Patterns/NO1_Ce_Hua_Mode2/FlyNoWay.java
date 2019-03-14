package Design_Patterns.NO1_Ce_Hua_Mode2;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }

}
