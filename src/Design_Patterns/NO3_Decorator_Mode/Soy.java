package Design_Patterns.NO3_Decorator_Mode;

/*
*  soy decorator  cost 0.15
* */

public class Soy extends CondimentDecorator {
    Beverage beverage;

    Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Soy";
    }
}
