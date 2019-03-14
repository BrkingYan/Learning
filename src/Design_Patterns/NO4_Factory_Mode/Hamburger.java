package Design_Patterns.NO4_Factory_Mode;

public abstract class Hamburger extends Food {

    double profit;
    public abstract double cost();
    public abstract void fire();
    public abstract void hot();
    public abstract void ice();
    public abstract void setType();
    public void changePrice(){

    }

}
