package Design_Patterns.NO3_Decorator_Mode;


/*
*  Whip decorator   costs 0.10
* */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    Whip(Beverage beverage){
        this.beverage = beverage;
    }


    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip";
    }
}
