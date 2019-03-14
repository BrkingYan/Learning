package Design_Patterns.NO3_Decorator_Mode;

public class Decaf_B4 extends Beverage {
    Decaf_B4(){
        description = "Decaf coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
