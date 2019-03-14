package Design_Patterns.NO1_Ce_Hua_Mode2;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void  setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }
}
