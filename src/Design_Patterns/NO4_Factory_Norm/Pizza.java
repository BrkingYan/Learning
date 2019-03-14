package Design_Patterns.NO4_Factory_Norm;

import Design_Patterns.NO4_Factory_Abstract.Cheese;
import Design_Patterns.NO4_Factory_Abstract.Clam;
import Design_Patterns.NO4_Factory_Abstract.PizzaIngerdientFactory;
import Design_Patterns.NO4_Factory_Abstract.Sauce;

import java.util.ArrayList;

 abstract class Pizza {
    String name;
    Sauce sauce;
    Clam clam;
    Cheese cheese;
    ArrayList<String> toppingList = new ArrayList<String>();


    PizzaIngerdientFactory factory;

    public void prepare(){
        System.out.println("preparing "+name+"......");
        System.out.println("with toppings :");
        if (toppingList.size() != 0) {
            for (int i = 0; i < toppingList.size() - 1; i++) {
                System.out.print(toppingList.get(i) + "/");
            }
            System.out.println(toppingList.get(toppingList.size() - 1));
        }
    }

    public abstract void bake();
    public abstract void cut();
    public abstract void box();
}
