package Design_Patterns.NO1_Ce_Hua_Mode2;


/*
* OO原则：   1、封装变化
*            2、多用组合，少用继承
*            3、针对接口编程，不针对实现编程
* */


/*
*     every duck "has a" FlyBehavior and a QuackBehavior
*     every DuckCall "has a" CallBehavior
* */



public class Test1 {
    public static void main (String[] args){
        Duck mallarduck = new MallardDuck();
        mallarduck.display();
        mallarduck.performFly();
        mallarduck.performQuack();
        mallarduck.setQuackBehavior(new QuackWithSpeak());
        mallarduck.performQuack();

        System.out.println();

        Duck robberduck = new RobberDuck();
        robberduck.display();
        robberduck.performFly();
        robberduck.performQuack();

        System.out.println();

        Duck modeduck  = new ModeDuck();
        mallarduck.display();
        modeduck.performFly();
        modeduck.setFlyBehavior(new FlyRocketPowered());
        modeduck.performFly();

        System.out.println();

        DuckCall dc = new DuckCall();
        dc.display();
        dc.performDuckCall();

        System.out.println();

        dc.setCallBehavior(new GaGaCall());
        dc.performDuckCall();


    }
}
