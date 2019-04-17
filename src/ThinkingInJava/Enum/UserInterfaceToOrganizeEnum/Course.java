package ThinkingInJava.Enum.UserInterfaceToOrganizeEnum;

import ThinkingInJava.Enum.EnumRandomUtil;

import java.util.Random;

/*
*  一个随机生成菜单的系统
* */
enum  Course {
    Dessert(Food.Dessert.class),
    Beverage(Food.Beverage.class),
    MainFood(Food.MainFood.class);
    private Food[] values;
    private static Random rand = new Random();

    //自定义构造器，该构造器会被编译器自动调用
    private Course(Class<? extends Food> foodType){
        values = foodType.getEnumConstants();
    }


    Food randomSelection(){
        return EnumRandomUtil.selectRandom(values);
    }

    public static void main(String[] args) {
        for (int i = 0;i< 5 ;i++){
            System.out.println("recipe " + (i+1));
            for (Course course : Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("------------");
        }
    }
}
