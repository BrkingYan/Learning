package Design_Patterns.NO9_Iterator_Mode;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenuWithIter implements Menu {
    Hashtable memuItems = new Hashtable();

    public CafeMenuWithIter(){
        addItem("soup of the day","a soup with a side salad",true,3.69);
        addItem("Burrito","a large burrito with whole pinto beans",true,4.29);
        addItem("Veggie Burger and Air Fries","Veggie Burger on a whole wheat bun,luttuce",false,.99);
    }

    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        memuItems.put(menuItem.getName(),menuItem);
    }

    @Override
    public Iterator createIterator() {
        return memuItems.values().iterator();
    }
}
