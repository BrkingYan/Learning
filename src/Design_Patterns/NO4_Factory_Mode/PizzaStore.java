package Design_Patterns.NO4_Factory_Mode;

public abstract class PizzaStore extends Store {
    public abstract Pizza createPizza(String type,PriceData priceData);
    public abstract Pizza createPizza(String type);
    public abstract void processPizza(Pizza pizza);

}
