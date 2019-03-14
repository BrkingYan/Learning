package Design_Patterns.NO3_Decorator_Mode;

/*
* milk decorator   costs 0.1$
* */

public class Milk extends CondimentDecorator {
    Beverage beverage;

    Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() + " + milk";
    }
}