package Design_Patterns.NO10_Composite_Pattern_With_Iterator;

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }

    public void printVegetarianMenu(){
        Iterator iterator = allMenus.createIterator();
        System.out.println("\n- - - - -Vegetarian Menu- - - - -");
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            try {
                /*
                * 判断每个component是否为素菜，如果是，就调用它的print()方法
                * */
                if (menuComponent.isVegetarian()){
                    menuComponent.print(); //只有MenuItem的print()方法可以被调用，不能调用Menu的print()方法
                }
            } catch (UnsupportedOperationException e) {

            }
            /*
            * 我们在菜单上实现isVegetarian()方法，让它永远抛出异常，如果异常真的发生了，就捕捉这个异常，然后继续遍历
            * */
        }
    }
}
