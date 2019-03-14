package Design_Patterns.NO1_Ce_Hua_Mode2;

public class RobberDuck extends Duck {

    RobberDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display(){
        System.out.println("I am a RobberDuck");
    }
}
