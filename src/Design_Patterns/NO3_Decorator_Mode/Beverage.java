package Design_Patterns.NO3_Decorator_Mode;

public abstract class Beverage {
    String description ;
    String size;

    public String getDescription(){
        return description;
    }

    public abstract double cost();

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }
}
