package Design_Patterns.NO10_Composite_Pattern;

/*
*   this is the leaf node
* */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean isVegetarian;
    double price;

    public MenuItem(String name,String description,boolean isVegetarian,double price){
        this.name = name;
        this.description = description;
        this.isVegetarian = isVegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return isVegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void print(){
        System.out.print(" " + getName());
        if (isVegetarian){
            System.out.print("   (V)  ");
        }
        System.out.println(", " + getPrice());
        System.out.println("    - -" + getDescription());
    }
}
