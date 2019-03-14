package Design_Patterns.NO9_Iterator_Mode;

import java.util.Iterator;

public class Waitress {
    public static void main(String[] args){
        PancakeHouseMenuWithIter pancakeHouseMenu = new PancakeHouseMenuWithIter();
        Iterator breakfastItems = pancakeHouseMenu.createIterator();//从Lou煎饼屋获取菜单

        DinnerMenuWithIter dinnerMenu = new DinnerMenuWithIter();
        Iterator lunchItems = dinnerMenu.createIterator();//从Mel餐厅获取菜单

        CafeMenuWithIter lunchMenu = new CafeMenuWithIter();
        Iterator cafeItems = lunchMenu.createIterator();//从Cafe店获取菜单



        //通过迭代器遍历Lou煎饼屋和Mel餐厅制作的所有菜品，将所有菜品信息打印出来
        //这样一来，不管是什么容器，只要用迭代器实现，然后将迭代器传入printMenu方法，就能将所有菜品信息打印出来
        System.out.println("Menu\n-----\n--Breakfast--");
        printMenu(breakfastItems);
        System.out.println("\n--Lunch--");
        printMenu(lunchItems);
        System.out.println("\n--Cafe-- ");
        printMenu(cafeItems);


/*
        //遍历Lou煎饼屋制作的所有早餐，将它们的信息打印出来
        for (int i = 0;i < breakfastItems.size();i++){
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.println(menuItem.getName() + "");
            System.out.println(menuItem.getPrice() + "");
            System.out.println(menuItem.getDescription());
        }

        //遍历Mel餐厅制作的所有中餐，将它们的信息打印出来
        for (int j = 0;j < lunchItems.length;j++){
            MenuItem menuItem = lunchItems[j];
            System.out.println(menuItem.getName() + "");
            System.out.println(menuItem.getPrice() + "");
            System.out.println(menuItem.getDescription());
        }
*/
    }

    public static void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ", " + menuItem.getPrice());
            System.out.print("--");
            System.out.println(menuItem.getDescription());
        }
    }
}
