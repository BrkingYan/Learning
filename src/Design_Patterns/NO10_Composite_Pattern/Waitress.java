package Design_Patterns.NO10_Composite_Pattern;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }

    public static void main(String[] args){
        //创建所有的 Menu 对象
        MenuComponent pancakeHouseMenu = new Menu("Pancake House Menu","Breakfast");
        MenuComponent dinnerMenu = new Menu("Dinner Menu","Lunch");
        MenuComponent cafeMenu = new Menu("Cafe Menu","Dinner");
        MenuComponent dessertMenu = new Menu("Dessert Menu","Dessert of course!");

//我们需要一个最顶层的菜单，它是allMenus
        MenuComponent allMenus = new Menu("All Menus","Include all menus");

        //这里的add()方法是composite的add()方法，即Menu类的add()方法，它将所有Menu都添加到顶层菜单allMenus的容器中
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinnerMenu);
        allMenus.add(cafeMenu);

        //给dinnerMenu添加一个菜单项 Pasta
        dinnerMenu.add(new MenuItem("Pasta","Spaghetti with Marinara Sauce , and a slice of sourdough bread",true,3.89));
        //给dinnerMenu添加一个子菜单
        dinnerMenu.add(dessertMenu);
        //给子菜单dessertMenu添加一个菜单项 Apple Pie
        dessertMenu.add(new MenuItem("Apple Pie","Apple Pie with a flakey crust",true,1.59));
        //构建服务员对象，让她打印菜品信息
        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
