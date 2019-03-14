package Design_Patterns.NO4_Factory_Simple;

 class SimplePizzaFactory {
     public Pizza createPizza(String type){
         Pizza pizza;
         if (type=="cheese"){
             pizza = new Pizza_Cheese();
         }
         else if (type=="clam"){
             pizza = new Pizza_Clam();
         }
         else
             throw new NullPointerException("没有这样的Pizza");
         return pizza;
     }
}
