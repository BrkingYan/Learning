package Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory;

public abstract class Item implements HTMLable {
    protected String description;

    Item(String description){
        this.description = description;
    }
    //transToHTML
}
