package Design_Patterns.NO9_Iterator_Mode;


import java.util.ArrayList;

/*
*  Lou 的煎饼屋的实现
* */
public class PancakeHouseMenu_Lou {
    ArrayList menuItems;

    public PancakeHouseMenu_Lou(){
        menuItems = new ArrayList();

        addItem("K&B's Pancake breakfast","Pancakes with scrambled eggs",true,2.99);
        addItem("Regular Pancake breakfast","Pancakes with fried eggs",true,2.99);
        addItem("Blueberry Pancake breakfast","Pancakes made with fresh blueberries",true,3.49);
    }

    public void addItem(String name,String description,boolean vegetarian,double price) {
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems(){
        return menuItems;
    }
}
