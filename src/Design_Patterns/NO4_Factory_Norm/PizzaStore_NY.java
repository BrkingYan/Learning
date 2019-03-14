package Design_Patterns.NO4_Factory_Norm;



 class PizzaStore_NY extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        if (type == "cheese"){
            pizza = new Pizza_Cheese_NY();
        }
        else if(type == "clam"){
            pizza = new Pizza_Clam_NY();
        }
        else
            throw new NullPointerException("no such pizza in NY Pizza Store");
        return pizza;
    }
}
