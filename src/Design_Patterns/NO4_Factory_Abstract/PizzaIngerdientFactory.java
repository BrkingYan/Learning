package Design_Patterns.NO4_Factory_Abstract;

public interface PizzaIngerdientFactory {
    public abstract Sauce createSauce(String type);
    public abstract Clam createClam(String type);
    public abstract Cheese createCheese(String type);
}
