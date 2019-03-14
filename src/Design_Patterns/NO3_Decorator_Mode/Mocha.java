package Design_Patterns.NO3_Decorator_Mode;

/*
* Mocha decorator   costs 0.20
* */

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Mocha";
    }
}
