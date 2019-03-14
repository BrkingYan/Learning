package Design_Patterns.NO3_Decorator_Mode;

public class Espresso_B3 extends Beverage {

    Espresso_B3(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
