package Design_Patterns.NO3_Decorator_Mode;

public class HouseBlend_B1 extends Beverage {


    HouseBlend_B1(){
        description = "HouseBlend coffee";
    }

    @Override
    public double cost() {
        return  0.89;
    }
}
