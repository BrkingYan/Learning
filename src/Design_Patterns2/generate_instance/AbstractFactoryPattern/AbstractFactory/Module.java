package Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory;

import java.util.ArrayList;


// " ģ��" �ǱȽϴ��Item
public abstract class Module extends Item {
    protected ArrayList<Item> itemList = new ArrayList<>();

    public Module(String description){
        super(description);
    }

    public void add(Item item){
        itemList.add(item);
    }
}
