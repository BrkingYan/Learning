package Design_Patterns.NO4_Factory_Mode;

public abstract class HamburgerStore extends Store implements Observer {
    public abstract Hamburger createHamburger(String type);
    public abstract Hamburger createHamburger(String type,double disCount);
    public abstract void processHamburger(Hamburger hamburger);
    public void update(double disCount){

    }

}
