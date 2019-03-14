package Design_Patterns.NO1_Ce_Hua_Mode2;

public class ModeDuck extends Duck {

    ModeDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a model duck");
    }
}
