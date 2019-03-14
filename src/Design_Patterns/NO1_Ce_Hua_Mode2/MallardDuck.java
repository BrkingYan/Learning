package Design_Patterns.NO1_Ce_Hua_Mode2;

public class MallardDuck extends Duck {

    MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("I am a MallardDuck");
    }
}
