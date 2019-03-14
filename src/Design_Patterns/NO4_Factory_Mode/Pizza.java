package Design_Patterns.NO4_Factory_Mode;

public abstract class Pizza extends Food implements Observer{

    PriceData priceData;

//    Pizza(PriceData pd){
//        this.priceData = pd;
//        priceData.register(this);
//    }


    public abstract void bake();
    public abstract void cut();
    public abstract void box();
    public abstract void setType();
    public abstract double cost();
}
