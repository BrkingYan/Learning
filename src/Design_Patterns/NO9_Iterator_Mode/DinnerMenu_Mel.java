package Design_Patterns.NO9_Iterator_Mode;

import java.util.Iterator;

/*
* Mel 的餐馆实现
* */
public class DinnerMenu_Mel  {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinnerMenu_Mel(){
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT","Bacon with lettuce,tomato and wheat",true,2.99);
        addItem("Hot Dog","a hot with relish and onions",false,3.05);
    }

    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        if (numberOfItems >= MAX_ITEMS){
            System.err.println("Sorry! menu is full , can't add item to menu");
        }else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }
    public MenuItem[] getMenuItems(){
        return menuItems;
    }

}
