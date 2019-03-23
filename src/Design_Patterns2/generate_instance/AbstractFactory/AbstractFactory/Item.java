package Design_Patterns2.generate_instance.AbstractFactory.AbstractFactory;

public abstract class Item implements HTMLable {
    protected String description;

    public Item(String description){
        this.description = description;
    }

    //transToHTML
}
