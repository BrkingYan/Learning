package Design_Patterns.NO4_Factory_Simple;

import java.util.ArrayList;

abstract class Pizza {
    String name;
    ArrayList<String> toppingList = new ArrayList<String>();
    public void prepare(){
        System.out.println("preparing "+name);
        System.out.println("with toppings :");
        for (int i=0;i<toppingList.size()-1;i++){
            System.out.print(toppingList.get(i)+"/");
        }
        System.out.println(toppingList.get(toppingList.size()-1));

    }

    public abstract void bake();
    public abstract void cut();
    public abstract void box();

}
