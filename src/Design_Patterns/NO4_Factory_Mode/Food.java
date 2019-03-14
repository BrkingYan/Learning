package Design_Patterns.NO4_Factory_Mode;

public abstract class Food  {

    PriceData priceData;



    String state = null;
    double disCount;
    public abstract double cost();
}
