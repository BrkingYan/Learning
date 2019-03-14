package Design_Patterns.NO4_Factory_Simple;

 class PizzaStore {
     SimplePizzaFactory simplePizzaFactory ;
     public PizzaStore(SimplePizzaFactory sf){
         this.simplePizzaFactory = sf;
     }
    public Pizza orderPizza(String type){
         Pizza pizza;
        pizza = simplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
