package Design_Patterns.NO9_Iterator_Mode;

import java.util.ArrayList;

public class Waiter {
    public static void main(String[] args){
        PancakeHouseMenu_Lou pancakeHouseMenu = new PancakeHouseMenu_Lou();
        ArrayList breakfastItems = pancakeHouseMenu.getMenuItems();//从Lou煎饼屋获取菜单

        DinnerMenu_Mel dinnerMenu = new DinnerMenu_Mel();
        MenuItem[] lunchItems = dinnerMenu.getMenuItems();//从Mel餐厅获取菜单

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
    }
}
