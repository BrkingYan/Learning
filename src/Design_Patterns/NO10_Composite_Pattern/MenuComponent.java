package Design_Patterns.NO10_Composite_Pattern;

/*
*  this is the upper interface
* */
public abstract class MenuComponent {
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public double getPrice(){
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }
}
