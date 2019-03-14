package Design_Patterns.NO3_Decorator_Mode;

public class DarkRoast_B2 extends Beverage {
    DarkRoast_B2(){
        description = "DarkRoast coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
