package Design_Patterns.NO4_Factory_Norm;

 class PizzaStore_Chicago extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        if (type == "cheese"){
            pizza = new Pizza_Cheese_Chicago();
        }
        else if (type == "clam"){
            pizza = new Pizza_Clam_Chicago();
        }
        else
            throw new NullPointerException("no such pizza in chicago pizza store");
        return pizza;
    }
}
