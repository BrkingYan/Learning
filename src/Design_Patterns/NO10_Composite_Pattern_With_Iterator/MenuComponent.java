package Design_Patterns.NO10_Composite_Pattern_With_Iterator;

import java.util.Iterator;

/*
* 现在为 MenuComponent 类添加 createIterator()方法
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

    public Iterator createIterator(){
        throw new UnsupportedOperationException();
    }
}
