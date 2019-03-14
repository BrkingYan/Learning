package Design_Patterns.NO4_Factory_Norm;

import Design_Patterns.NO4_Factory_Abstract.ChicagoPizzaIngredientFactory;
import Design_Patterns.NO4_Factory_Abstract.NYPizzaIngredientFactory;

class PizzaStore_BJ extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        if (type == "cheese"){
            pizza = new Pizza_Cheese_BJ(new NYPizzaIngredientFactory());
        }
        else if(type == "clam"){
            pizza = new Pizza_Clam_BJ(new ChicagoPizzaIngredientFactory());
        }
        else
            throw new NullPointerException("no such pizza in BJ Pizza Store");
        return pizza;
    }

}
