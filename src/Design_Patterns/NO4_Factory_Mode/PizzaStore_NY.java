package Design_Patterns.NO4_Factory_Mode;

public class PizzaStore_NY extends PizzaStore {

    //PriceData priceData;

    PizzaStore_NY(){
        this.brand = "(Made in New York Pizza Store)";
    }

    public Pizza createPizza(String type,PriceData priceData){
        Pizza pizza = null;
//        pizza.state += this.brand;

        if(type == "cheese"){
            pizza = new Pizza_cheese(priceData);
            setBrand(pizza);
        }
        else if(type == "clam"){
            pizza = new Pizza_clam(priceData);
            setBrand(pizza);
        }

        processPizza(pizza);
        return pizza;
    }


    public Pizza createPizza(String type){
        Pizza pizza = null;
//        pizza.state += this.brand;

        if(type == "cheese"){
            pizza = new Pizza_cheese();
            setBrand(pizza);
        }
        else if(type == "clam"){
            pizza = new Pizza_clam();
            setBrand(pizza);
        }

        processPizza(pizza);
        return pizza;
    }

    public void processPizza(Pizza pizza){
        pizza.bake();
        pizza.cut();
        pizza.box();
        pizza.setType();
    }

    public void setBrand(Pizza pizza){
        pizza.state = brand;
    }
}
