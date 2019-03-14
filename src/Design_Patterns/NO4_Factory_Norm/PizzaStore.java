package Design_Patterns.NO4_Factory_Norm;



abstract class PizzaStore {
    public abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = this.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
