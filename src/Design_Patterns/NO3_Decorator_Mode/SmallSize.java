package Design_Patterns.NO3_Decorator_Mode;

public class SmallSize extends SizeDecorator {
    Beverage beverage;

    SmallSize(Beverage beverage){
        this.beverage = beverage;
        this.beverage.setSize(" + (Small Cup)");
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + beverage.getSize();
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
