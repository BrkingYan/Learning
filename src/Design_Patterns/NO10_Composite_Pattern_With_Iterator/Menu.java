package Design_Patterns.NO10_Composite_Pattern_With_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    //创建一个ArrayList当作容器，用于装MenuItem或者其他子菜单，MenuItem和其他菜单项都是MenuComponent类型
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name,String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }


    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return (MenuComponent) menuComponents.get(i);
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
    public Iterator createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();

        /*
         *这是递归的思想
         * 这里用到了迭代器，用它遍历所有组件，遍历的时候可能遇到MenuItem，也可能遇到其他菜单，但是它们都有print()方法，当遍历到它们时，不管是谁，在那调用print()方法准没错
         * */
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
}
