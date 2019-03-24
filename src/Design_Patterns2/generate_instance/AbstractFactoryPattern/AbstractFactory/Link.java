package Design_Patterns2.generate_instance.AbstractFactoryPattern.AbstractFactory;


//  " ����" �� �Ƚ�С��Item
public abstract class Link extends Item {

    protected String url;
    public Link(String description, String url){
        super(description);
        this.url = url;
    }
}
