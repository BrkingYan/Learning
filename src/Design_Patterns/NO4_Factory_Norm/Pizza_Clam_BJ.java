package Design_Patterns.NO4_Factory_Norm;

import Design_Patterns.NO4_Factory_Abstract.PizzaIngerdientFactory;
//import NO4_Factory_Abstract.*;

public class Pizza_Clam_BJ extends Pizza {
    PizzaIngerdientFactory factory;

    public Pizza_Clam_BJ(PizzaIngerdientFactory fc) {
        factory = fc;
        name = "BJ store clam pizza";
        toppingList.add("BJ salt");
        toppingList.add("BJ sauce");
    }

    public void prepare(){
        factory.createSauce("white");
        factory.createClam("froze");
        factory.createCheese("thin");
        System.out.println("preparing "+name+"......");
        System.out.println("with toppings :");
        if (toppingList.size() != 0) {
            for (int i = 0; i < toppingList.size() - 1; i++) {
                System.out.print(toppingList.get(i) + "/");
            }
            System.out.println(toppingList.get(toppingList.size() - 1));
        }
    }

    @Override
    public void bake() {
        System.out.println("bake for 15min(BJ time)");
    }

    @Override
    public void cut() {
        System.out.println("cut with BJ knife");
    }

    @Override
    public void box() {
        System.out.println("box with BJ box");
    }
}
